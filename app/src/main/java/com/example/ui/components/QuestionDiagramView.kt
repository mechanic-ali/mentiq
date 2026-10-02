package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.Question

@Composable
fun QuestionDiagramView(
    question: Question,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .testTag("question_diagram_card_${question.id}"),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
        ),
        shape = RoundedCornerShape(16.dp),
        border = CardDefaults.outlinedCardBorder()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    color = MaterialTheme.colorScheme.primaryContainer,
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "Sual #${question.id} • ${question.category}",
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }

                Surface(
                    color = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.7f),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "Sual Fiquru",
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            when (question.diagramType) {
                "circle_8_sectors" -> Circle8SectorsDiagram()
                "brick_pyramid", "number_pyramid" -> PyramidDiagram(question)
                "circle_pyramid_calc" -> CirclePyramidDiagram()
                "matrix_2x2", "box_2x2_series", "matrix_proportional_diff" -> Matrix2x2Diagram(question)
                "diamond_cross_product", "diamond_product_diff" -> DiamondCrossDiagram(question)
                "triplet_boxes" -> TripletBoxesDiagram(question)
                "circle_square_diff" -> CircleSquareDiffDiagram(question)
                "algebra_pyramid" -> AlgebraPyramidDiagram()
                "two_row_progression" -> TwoRowProgressionDiagram(question)
                "l_block_half_sum" -> LBlockDiagram()
                "trapezoid_average" -> TrapezoidDiagram()
                "polygon_algebra_code", "shape_side_division" -> PolygonCodeDiagram(question)
                "pie_chart_fraction" -> PieChartDiagram()
                "digit_sum_boxes" -> DigitSumBoxesDiagram()
                else -> GenericSchemeDiagram(question)
            }
        }
    }
}

@Composable
private fun Circle8SectorsDiagram() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.surface)
                .border(2.dp, MaterialTheme.colorScheme.primary, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            // Sector labels
            Column(
                modifier = Modifier.fillMaxSize().padding(12.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    BadgeText(text = "3", isHighlight = true)
                    BadgeText(text = "2", isHighlight = true)
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    BadgeText(text = "6")
                    BadgeText(text = "24")
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    BadgeText(text = "6")
                    BadgeText(text = "?", isHighlight = true, isTarget = true)
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    BadgeText(text = "18", isHighlight = true)
                    BadgeText(text = "12", isHighlight = true)
                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Qarşı sektorlar: 2 x 12 = 24  |  3 x 18 = 54 (?)",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
private fun PyramidDiagram(question: Question) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Row(horizontalArrangement = Arrangement.Center) {
            BadgeBox(text = "?", isTarget = true)
        }
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            BadgeBox(text = "79")
            BadgeBox(text = "85")
        }
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            BadgeBox(text = "39")
            BadgeBox(text = "40")
            BadgeBox(text = "45")
        }
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            BadgeBox(text = "18")
            BadgeBox(text = "21")
            BadgeBox(text = "19")
            BadgeBox(text = "26")
        }
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            BadgeBox(text = "6")
            BadgeBox(text = "12")
            BadgeBox(text = "9")
            BadgeBox(text = "10")
            BadgeBox(text = "16")
        }
    }
}

@Composable
private fun CirclePyramidDiagram() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Row { BadgeCircle(text = "C", isTarget = true) }
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            BadgeCircle(text = "9")
            BadgeCircle(text = "B", isTarget = true)
        }
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            BadgeCircle(text = "3")
            BadgeCircle(text = "7")
            BadgeCircle(text = "7")
        }
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            BadgeCircle(text = "1")
            BadgeCircle(text = "3")
            BadgeCircle(text = "A", isTarget = true)
            BadgeCircle(text = "3")
        }
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            BadgeCircle(text = "1")
            BadgeCircle(text = "1")
            BadgeCircle(text = "3")
            BadgeCircle(text = "3")
            BadgeCircle(text = "1")
        }
    }
}

@Composable
private fun AlgebraPyramidDiagram() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Row { BadgeBox(text = "A", isTarget = true) }
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            BadgeBox(text = "B", isTarget = true)
            BadgeBox(text = "41")
        }
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            BadgeBox(text = "37")
            BadgeBox(text = "C", isTarget = true)
            BadgeBox(text = "19")
        }
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            BadgeBox(text = "D")
            BadgeBox(text = "E")
            BadgeBox(text = "F")
            BadgeBox(text = "11")
        }
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            BadgeBox(text = "L", isTarget = true)
            BadgeBox(text = "G")
            BadgeBox(text = "6")
            BadgeBox(text = "H")
            BadgeBox(text = "K", isTarget = true)
        }
    }
}

@Composable
private fun Matrix2x2Diagram(question: Question) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        MatrixCard(title = "Nümunə 1", r1 = "128  64", r2 = "16   32")
        MatrixCard(title = "Nümunə 2", r1 = "832  208", r2 = " ?    52", hasTarget = true)
    }
}

@Composable
private fun DiamondCrossDiagram(question: Question) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        DiamondItem(top = "6", right = "8", bottom = "7", left = "5", center = "13")
        DiamondItem(top = "13", right = "4", bottom = "2", left = "9", center = "34")
        DiamondItem(top = "12", right = "3", bottom = "4", left = "3", center = "?", isTarget = true)
    }
}

@Composable
private fun DiamondItem(
    top: String,
    right: String,
    bottom: String,
    left: String,
    center: String,
    isTarget: Boolean = false
) {
    Card(
        modifier = Modifier.size(105.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(top, fontWeight = FontWeight.Bold, fontSize = 12.sp)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(left, fontWeight = FontWeight.Bold, fontSize = 12.sp)
                Surface(
                    color = if (isTarget) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.secondaryContainer,
                    shape = RoundedCornerShape(4.dp)
                ) {
                    Text(
                        center,
                        modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp),
                        fontWeight = FontWeight.ExtraBold,
                        color = if (isTarget) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSecondaryContainer,
                        fontSize = 13.sp
                    )
                }
                Text(right, fontWeight = FontWeight.Bold, fontSize = 12.sp)
            }
            Text(bottom, fontWeight = FontWeight.Bold, fontSize = 12.sp)
        }
    }
}

@Composable
private fun CircleSquareDiffDiagram(question: Question) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        CircleSplitItem(top = "69", left = "13", right = "10")
        CircleSplitItem(top = "81", left = "15", right = "12")
        CircleSplitItem(top = "?", left = "16", right = "9", isTarget = true)
    }
}

@Composable
private fun CircleSplitItem(top: String, left: String, right: String, isTarget: Boolean = false) {
    Box(
        modifier = Modifier
            .size(90.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.surface)
            .border(2.dp, MaterialTheme.colorScheme.outlineVariant, CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(6.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface(
                color = if (isTarget) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.secondaryContainer,
                shape = RoundedCornerShape(4.dp)
            ) {
                Text(
                    top,
                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
                    fontWeight = FontWeight.Bold,
                    color = if (isTarget) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSecondaryContainer,
                    fontSize = 13.sp
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(left, fontWeight = FontWeight.Medium, fontSize = 12.sp)
                Text(right, fontWeight = FontWeight.Medium, fontSize = 12.sp)
            }
        }
    }
}

@Composable
private fun TripletBoxesDiagram(question: Question) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TripletRow("478", "600", "138")
        TripletRow("341", "757", "418")
        TripletRow("512", "672", "164")
        TripletRow("253", "?", "526", isTarget = true)
    }
}

@Composable
private fun TripletRow(left: String, mid: String, right: String, isTarget: Boolean = false) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        BadgeBox(left, width = 70)
        Spacer(modifier = Modifier.width(8.dp))
        BadgeBox(mid, width = 76, isTarget = isTarget)
        Spacer(modifier = Modifier.width(8.dp))
        BadgeBox(right, width = 70)
    }
}

@Composable
private fun TwoRowProgressionDiagram(question: Question) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                listOf("1", "2", "4", "5", "6", "7", "8", "9").forEach {
                    Text(it, modifier = Modifier.weight(1f), textAlign = TextAlign.Center, fontWeight = FontWeight.Bold)
                }
            }
            HorizontalDivider(modifier = Modifier.padding(vertical = 4.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                listOf("4", "16", "40", "60", "84", "112", "?", "...").forEach {
                    Text(
                        it,
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.Center,
                        fontWeight = if (it == "?") FontWeight.ExtraBold else FontWeight.Normal,
                        color = if (it == "?") MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        }
    }
}

@Composable
private fun LBlockDiagram() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        LBlockItem(top = "24", left = "5", right = "17")
        LBlockItem(top = "42", left = "6", right = "27")
        LBlockItem(top = "66", left = "7", right = "40")
        LBlockItem(top = "78", left = "8", right = "?", isTarget = true)
    }
}

@Composable
private fun LBlockItem(top: String, left: String, right: String, isTarget: Boolean = false) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        BadgeBox(top, width = 50)
        Spacer(modifier = Modifier.height(2.dp))
        Row {
            BadgeBox(left, width = 28)
            BadgeBox(right, width = 36, isTarget = isTarget)
        }
    }
}

@Composable
private fun TrapezoidDiagram() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        TrapezoidItem("69", "63", "75")
        TrapezoidItem("42", "34", "50")
        TrapezoidItem("94", "71", "117")
        TrapezoidItem("?", "59", "95", isTarget = true)
    }
}

@Composable
private fun TrapezoidItem(top: String, left: String, right: String, isTarget: Boolean = false) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        BadgeBox(top, width = 45, isTarget = isTarget)
        Spacer(modifier = Modifier.height(4.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
            Text(left, fontSize = 11.sp, fontWeight = FontWeight.Bold)
            Text(right, fontSize = 11.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
private fun PolygonCodeDiagram(question: Question) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ShapeTextBadge("Dördbucaqlı (4)", "8 ; 16")
            ShapeTextBadge("Yeddibucaqlı (7)", "14 ; 49")
            ShapeTextBadge("Altıbucaqlı (6)", "?", isTarget = true)
        }
    }
}

@Composable
private fun PieChartDiagram() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Card(
            modifier = Modifier.size(110.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
        ) {
            Column(
                modifier = Modifier.fillMaxSize().padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text("1/4 Qara", fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(4.dp))
                Text("Dairə 1 -> 1/4", fontSize = 12.sp)
            }
        }
        Icon(Icons.Default.ArrowForward, contentDescription = null)
        Card(
            modifier = Modifier.size(110.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
        ) {
            Column(
                modifier = Modifier.fillMaxSize().padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text("4/8 Qara", fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
                Spacer(modifier = Modifier.height(4.dp))
                Text("Dairə 2 -> ?", fontSize = 12.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
private fun DigitSumBoxesDiagram() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        DigitSumItem("134", "9")
        DigitSumItem("52", "8")
        DigitSumItem("17", "9")
        DigitSumItem("40", "5")
        DigitSumItem("182", "?", isTarget = true)
    }
}

@Composable
private fun DigitSumItem(top: String, bot: String, isTarget: Boolean = false) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        BadgeBox(top, width = 50)
        Spacer(modifier = Modifier.height(4.dp))
        BadgeBox(bot, width = 40, isTarget = isTarget)
    }
}

@Composable
private fun GenericSchemeDiagram(question: Question) {
    Surface(
        color = MaterialTheme.colorScheme.surface,
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.Default.Analytics,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(36.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = question.title,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Medium
            )
            if (question.diagramData.isNotEmpty()) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = question.diagramData.values.joinToString(" • "),
                    style = MaterialTheme.typography.labelMedium,
                    fontFamily = FontFamily.Monospace,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        }
    }
}

@Composable
private fun MatrixCard(title: String, r1: String, r2: String, hasTarget: Boolean = false) {
    Card(
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(title, style = MaterialTheme.typography.labelSmall)
            Spacer(modifier = Modifier.height(4.dp))
            Text(r1, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold, fontSize = 14.sp)
            Text(
                r2,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = if (hasTarget) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

@Composable
private fun BadgeText(text: String, isHighlight: Boolean = false, isTarget: Boolean = false) {
    Text(
        text = text,
        fontWeight = if (isHighlight || isTarget) FontWeight.Bold else FontWeight.Medium,
        fontSize = if (isTarget) 18.sp else 14.sp,
        color = when {
            isTarget -> MaterialTheme.colorScheme.error
            isHighlight -> MaterialTheme.colorScheme.primary
            else -> MaterialTheme.colorScheme.onSurface
        }
    )
}

@Composable
private fun BadgeBox(text: String, width: Int = 45, isTarget: Boolean = false) {
    Surface(
        modifier = Modifier.width(width.dp).height(34.dp),
        color = if (isTarget) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surface,
        shape = RoundedCornerShape(6.dp),
        border = CardDefaults.outlinedCardBorder()
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(
                text = text,
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp,
                color = if (isTarget) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

@Composable
private fun BadgeCircle(text: String, isTarget: Boolean = false) {
    Box(
        modifier = Modifier
            .size(38.dp)
            .clip(CircleShape)
            .background(if (isTarget) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surface)
            .border(1.5.dp, MaterialTheme.colorScheme.outlineVariant, CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontWeight = FontWeight.Bold,
            fontSize = 13.sp,
            color = if (isTarget) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
        )
    }
}

@Composable
private fun ShapeTextBadge(title: String, code: String, isTarget: Boolean = false) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = if (isTarget) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surface
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(title, style = MaterialTheme.typography.labelSmall)
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                code,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 14.sp,
                color = if (isTarget) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
            )
        }
    }
}
