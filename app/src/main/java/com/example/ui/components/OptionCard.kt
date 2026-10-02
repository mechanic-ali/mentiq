package com.example.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OptionCard(
    optionText: String,
    optionLetter: String,
    isSelected: Boolean,
    isCorrectOption: Boolean,
    showResult: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val backgroundColor by animateColorAsState(
        targetValue = when {
            showResult && isCorrectOption -> Color(0xFF10B981).copy(alpha = 0.15f)
            showResult && isSelected && !isCorrectOption -> Color(0xFFEF4444).copy(alpha = 0.15f)
            isSelected -> MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.6f)
            else -> MaterialTheme.colorScheme.surface
        },
        label = "optionBgColor"
    )

    val borderColor by animateColorAsState(
        targetValue = when {
            showResult && isCorrectOption -> Color(0xFF10B981)
            showResult && isSelected && !isCorrectOption -> Color(0xFFEF4444)
            isSelected -> MaterialTheme.colorScheme.primary
            else -> MaterialTheme.colorScheme.outlineVariant
        },
        label = "optionBorderColor"
    )

    val badgeColor = when {
        showResult && isCorrectOption -> Color(0xFF10B981)
        showResult && isSelected && !isCorrectOption -> Color(0xFFEF4444)
        isSelected -> MaterialTheme.colorScheme.primary
        else -> MaterialTheme.colorScheme.secondaryContainer
    }

    Surface(
        modifier = modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = 52.dp)
            .testTag("option_button_$optionLetter")
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(14.dp),
        color = backgroundColor,
        border = BorderStroke(if (isSelected || (showResult && isCorrectOption)) 2.dp else 1.dp, borderColor)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier.size(36.dp),
                shape = CircleShape,
                color = badgeColor
            ) {
                Box(contentAlignment = Alignment.Center) {
                    if (showResult && isCorrectOption) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = "Doğru variant",
                            tint = Color.White,
                            modifier = Modifier.size(20.dp)
                        )
                    } else if (showResult && isSelected && !isCorrectOption) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Səhv variant",
                            tint = Color.White,
                            modifier = Modifier.size(20.dp)
                        )
                    } else {
                        Text(
                            text = optionLetter,
                            fontWeight = FontWeight.Bold,
                            color = if (isSelected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSecondaryContainer,
                            fontSize = 15.sp
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.width(14.dp))

            Text(
                text = optionText,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = if (isSelected || (showResult && isCorrectOption)) FontWeight.SemiBold else FontWeight.Normal,
                color = when {
                    showResult && isCorrectOption -> Color(0xFF047857)
                    showResult && isSelected && !isCorrectOption -> Color(0xFFB91C1C)
                    else -> MaterialTheme.colorScheme.onSurface
                },
                modifier = Modifier.weight(1f)
            )
        }
    }
}
