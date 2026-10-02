package com.example.data.repository

import com.example.data.model.Question

val questionsPart3: List<Question> = listOf(
    Question(
        id = 61,
        title = "Sual 61. Qövs və blok parametrləri: a, b, c tapın.",
        category = "Blok və Qövs",
        options = listOf("A) 182; 13; 25", "B) 212; 25; 13", "C) 152; 13; 25", "D) 190; 16; 22", "E) 128; 16; 25"),
        correctOption = "A",
        hintProposal = "💡 Təklif: Alt ədəd iki ədədin cəmidir (c = 11 + 14 = 25). Üst qövs isə: (ilk ədəd + 2) * ikinci ədəddir!",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            Hər blokda iki ədəd verilib:
            Blok 1: [5, 8] -> Alt: 5 + 8 = 13! Üst qövs: (5 + 2) * 8 = 7 * 8 = 56!
            Blok 2: [7, 10] -> Alt: 7 + 10 = 17! Üst qövs: (7 + 2) * 10 = 9 * 10 = 90!
            Blok 3: [9, 12] -> Alt: 9 + 12 = 21! Üst qövs: (9 + 2) * 12 = 11 * 12 = 132!
            
            Blok 4: [11, 14]:
            c = 11 + 14 = 25!
            b = 11 + 2 = 13 (vuruq əmsalı)
            a = (11 + 2) * 14 = 13 * 14 = 182!
            
            Deməli: a = 182; b = 13; c = 25.
            
            🎯 **Nəticə:** Düzgün cavab: A) 182; 13; 25.
        """.trimIndent(),
        diagramType = "arc_block_formula",
        diagramData = mapOf("ans" to "182; 13; 25")
    ),
    Question(
        id = 62,
        title = "Sual 62. Romb və üçbucaqlarda daxili ədədin tapılması.",
        category = "Fiqur Əməliyyatları",
        options = listOf("A) 87", "B) 13", "C) 12", "D) 34", "E) 23"),
        correctOption = "B",
        hintProposal = "💡 Təklif: (Üst hasillər) - (Alt hasillər) düsturunu yoxlayın: (7*9) - (3*8) = 63 - 24 = 39!",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            Mərkəzdəki ədəd = (Üst tərəflərin hasili) - (Alt tərəflərin hasili)!
            
            Nümunələr:
            1-ci fiqur: (7 * 9) - (3 * 8) = 63 - 24 = 39!
            2-ci fiqur: (12 * 6) - (5 * 9) = 72 - 45 = 27!
            3-cü fiqur: (14 * 8) - (6 * 6) = 112 - 36 = 76!
            4-cü fiqur: (1 * 1) - (1 * 1) = 1 - 1 = 0!
            
            5-ci fiqur üçün:
            Üst: 5 və 8. Alt: 3 və 9.
            Mərkəz '?' = (5 * 8) - (3 * 9) = 40 - 27 = 13!
            
            🎯 **Nəticə:** Düzgün cavab: B) 13.
        """.trimIndent(),
        diagramType = "diamond_product_diff",
        diagramData = mapOf("calc" to "(5 * 8) - (3 * 9) = 13")
    ),
    Question(
        id = 63,
        title = "Sual 63. Dördbucaqlı sektorlardan alt ovala keçid.",
        category = "Sektor Hasilləri Nisbəti",
        options = listOf("A) 14", "B) 8", "C) 9", "D) 11", "E) 15"),
        correctOption = "C",
        hintProposal = "💡 Təklif: (Üst iki ədədin hasili) / (Alt iki ədədin hasili) düsturunu tətbiq edin: (6*14) / (2*2) = 21!",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            Aşağıdakı ovaldakı ədəd = (Üst sol * Üst sağ) / (Alt sol * Alt sağ)!
            
            Nümunələr:
            1-ci dairə: (6 * 14) / (2 * 2) = 84 / 4 = 21!
            2-ci dairə: (9 * 16) / (2 * 3) = 144 / 6 = 24!
            3-cü dairə: (26 * 8) / (4 * 4) = 208 / 16 = 13!
            4-cü dairə: (0 * 1) / (1 * 1) = 0 / 1 = 0!
            
            5-ci dairə üçün:
            Üst: 12 və 51. Alt: 17 və 4.
            Oval '?' = (12 * 51) / (17 * 4) = (12 / 4) * (51 / 17) = 3 * 3 = 9!
            
            🎯 **Nəticə:** Düzgün cavab: C) 9.
        """.trimIndent(),
        diagramType = "circle_ratio_oval",
        diagramData = mapOf("calc" to "(12 * 51) / (17 * 4) = 9")
    ),
    Question(
        id = 64,
        title = "Sual 64. 3x3 matrislərin mərkəz ədədi qanunauyğunluğu.",
        category = "3x3 Matris Mərkəzi",
        options = listOf("A) 8", "B) 7", "C) 3", "D) 9", "E) 4"),
        correctOption = "B",
        hintProposal = "💡 Təklif: Xarici 8 xananın cəminin üzərinə 1 gəlin və kvadrat kökünü alın: √(Cəm + 1) = Mərkəz!",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            Hər 3x3 matrisdə xaricdəki 8 ədədin cəmi: (Mərkəz)^2 - 1 düsturunu verir!
            Yəni: √(Xarici cəm + 1) = Mərkəzdəki ədəd!
            
            Nümunələri yoxlayaq:
            1-ci matris: Xarici cəm = 3+9+5+3+2+0+5+8 = 35. √(35 + 1) = √36 = 6! (Mərkəz = 6)
            2-ci matris: Xarici cəm = 3+2+0+1+3+1+3+2 = 15. √(15 + 1) = √16 = 4! (Mərkəz = 4)
            3-cü matris: Xarici cəm = 2+2+3+2+3+3+6+3 = 24. √(24 + 1) = √25 = 5! (Mərkəz = 5)
            
            İndi 4-cü matris üçün xarici ədədləri toplayaq:
            Xarici ədədlər: 12, 8, 1, 9, 6, 3, 6, 3.
            Cəm = 12 + 8 + 1 + 9 + 6 + 3 + 6 + 3 = 48!
            √(48 + 1) = √49 = 7!
            Deməli mərkəzdəki '?' = 7!
            
            🎯 **Nəticə:** Düzgün cavab: B) 7.
        """.trimIndent(),
        diagramType = "matrix_center_calc",
        diagramData = mapOf("calc" to "√(48 + 1) = 7")
    ),
    Question(
        id = 65,
        title = "Sual 65. Dairələr silsiləsində naməlum mərkəz ədədi.",
        category = "Simmetrik Dairələr",
        options = listOf("A) 22", "B) 21", "C) 18", "D) 20", "E) 16"),
        correctOption = "D",
        hintProposal = "💡 Təklif: Baş və gövdə dairələri arasındakı fərqlərə baxın: 12-10=2, 13-12=1, 19-14=5, 2-1=1, 22-?=2.",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            Baş və gövdə dairələrinin fərqləri simmetrik polindrom ardıcıllıq təşkil edir:
            1-ci: 12 - 10 = 2
            2-ci: 13 - 12 = 1
            3-cü: 19 - 14 = 5
            4-cü: 2 - 1 = 1
            5-ci: 22 - ? = 2
            Fərqlər: 2, 1, 5, 1, 2 (simmetrik).
            Buradan: 22 - ? = 2 => ? = 20!
            
            🎯 **Nəticə:** Düzgün cavab: D) 20.
        """.trimIndent(),
        diagramType = "figure_circles_series",
        diagramData = mapOf("ans" to "20")
    ),
    Question(
        id = 66,
        title = "Sual 66. Üçbucağın təpəsi və daxili ədədi arasındakı bərabərlik.",
        category = "Üçbucaq Təpələri",
        options = listOf("A) 25", "B) 18", "C) 21", "D) 17", "E) 15"),
        correctOption = "D",
        hintProposal = "💡 Təklif: Hər üçbucaqda daxildəki ədədin təpədəki ədədlə eyni olduğunu müşahidə edin: 12->12, 1->1, 8->8, 0->0!",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            Bütün üçbucaqlarda daxildəki ədəd təpə bucağındakı ədədə bərabərdir:
            1-ci üçbucaq: Təpə = 12, Daxil = 12.
            2-ci üçbucaq: Təpə = 1, Daxil = 1.
            3-cü üçbucaq: Təpə = 8, Daxil = 8.
            4-cü üçbucaq: Təpə = 0, Daxil = 0.
            
            5-ci üçbucaqda təpə nöqtəsində 17 yazılıb.
            Deməli daxildəki '?' = 17 olmalıdır!
            
            🎯 **Nəticə:** Düzgün cavab: D) 17.
        """.trimIndent(),
        diagramType = "triangle_identity",
        diagramData = mapOf("ans" to "17")
    ),
    Question(
        id = 67,
        title = "Sual 67. Dairələrdə kvadratlar fərqi qanunauyğunluğu.",
        category = "Kvadratlar Fərqi",
        options = listOf("A) 75", "B) 125", "C) 175", "D) 180", "E) 96"),
        correctOption = "C",
        hintProposal = "💡 Təklif: Üst sektor = (Sol alt)^2 - (Sağ alt)^2 düsturunu yoxlayın: 13^2 - 10^2 = 169 - 100 = 69!",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            Üst sektordakı ədəd aşağıdakı iki sektorun kvadratlarının fərqinə bərabərdir:
            
            1-ci dairə: 13^2 - 10^2 = 169 - 100 = 69!
            2-ci dairə: 15^2 - 12^2 = 225 - 144 = 81!
            3-cü dairə: 0^2 - 0^2 = 0!
            4-cü dairə: 14^2 - 10^2 = 196 - 100 = 96!
            
            5-ci dairə üçün:
            Sol alt = 16, Sağ alt = 9.
            Üst '?' = 16^2 - 9^2 = 256 - 81 = 175!
            
            🎯 **Nəticə:** Düzgün cavab: C) 175.
        """.trimIndent(),
        diagramType = "circle_square_diff",
        diagramData = mapOf("calc" to "16^2 - 9^2 = 256 - 81 = 175")
    ),
    Question(
        id = 68,
        title = "Sual 68. İç-içə çəkilmiş fiqurların tərəf saylarının kodlaşdırılması.",
        category = "İç-içə Fiqurlar",
        options = listOf("A) 4+3", "B) 3+4+0", "C) 7+0", "D) 4+0+3+0", "E) 0+4+3"),
        correctOption = "B",
        hintProposal = "💡 Təklif: Fiqurların təbəqələrini (üçbucaq=3, dördbucaq=4, çevrə=0) ardıcıllıqla toplayın.",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            Fiqurların tərəf sayları:
            Çevrə = 0 tərəf
            Üçbucaq = 3 tərəf
            Kvadrat = 4 tərəf
            
            3-cü şəkildə fiqurlar: Üçbucaq (3) daxilində Kvadrat (4), onun daxilində Dairə (0).
            Bu ardıcıllıq: 3 + 4 + 0 kimi ifadə olunur.
            
            🎯 **Nəticə:** Düzgün cavab: B) 3+4+0.
        """.trimIndent(),
        diagramType = "nested_shapes_code",
        diagramData = mapOf("ans" to "3+4+0")
    ),
    Question(
        id = 69,
        title = "Sual 69. Parovoz fiqurunun hissələrinin say tərkibi.",
        category = "Şəkil Analizi",
        options = listOf("A) 4; 5; 4; 4; 4", "B) 5; 4; 4; 4; 4", "C) 4; 4; 5; 4; 4", "D) 4; 4; 5; 4", "E) 4; 4; 4; 5"),
        correctOption = "C",
        hintProposal = "💡 Təklif: Pəncərələr, təkərlər, boru və kabin detallarının say ardıcıllığını sayın.",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            Qatar 1 -> 3; 4; 4; 3; 4
            Qatar 2 -> 4; 3; 5; 3; 4
            Qatar 3-də: 4 ön pəncərə zolağı, 4 təkər, 5 tərəfli kabin konturu, 4 daxili element:
            Kod: 4; 4; 5; 4; 4.
            
            🎯 **Nəticə:** Düzgün cavab: C) 4; 4; 5; 4; 4.
        """.trimIndent(),
        diagramType = "train_elements_code",
        diagramData = mapOf("ans" to "4; 4; 5; 4; 4")
    ),
    Question(
        id = 70,
        title = "Sual 70. Budaqlanmış dairələr şəbəkəsində ədəd əlaqəsi.",
        category = "Budaqlanmış Ağac",
        options = listOf("A) 79", "B) 54", "C) 43", "D) 94", "E) 11"),
        correctOption = "B",
        hintProposal = "💡 Təklif: Budaqlardakı fərqlər və tərs çevrilmiş rəqəmlər əlaqəsinə baxın.",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            Budaqlarda ədədlər arasındakı rəqəm əməliyyatları:
            Sonuncu budaq üçün hesablandıqda naməlum '?' qiyməti 54 təşkil edir.
            
            🎯 **Nəticə:** Düzgün cavab: B) 54.
        """.trimIndent(),
        diagramType = "tree_branches_circles",
        diagramData = mapOf("ans" to "54")
    ),
    Question(
        id = 71,
        title = "Sual 71. Romb üçlüklərində kvadratlar cəmi.",
        category = "Kvadratlar Cəmi",
        options = listOf("A) 53", "B) 11", "C) 74", "D) 65", "E) 56"),
        correctOption = "D",
        hintProposal = "💡 Təklif: Orta romb = (Sol)^2 + (Sağ)^2 düsturunu yoxlayın: 11^2 + 3^2 = 121 + 9 = 130!",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            Hər sətirdə orta rombdakı ədəd sol və sağ romblardakı ədədlərin kvadratlarının cəminə bərabərdir!
            
            Sətir 1: 11^2 + 3^2 = 121 + 9 = 130!
            Sətir 2: 1^2 + 6^2 = 1 + 36 = 37!
            Sətir 3: 9^2 + 2^2 = 81 + 4 = 85!
            
            Sətir 4 üçün:
            Sol = 7, Sağ = 4.
            Orta '?' = 7^2 + 4^2 = 49 + 16 = 65!
            
            🎯 **Nəticə:** Düzgün cavab: D) 65.
        """.trimIndent(),
        diagramType = "diamond_squares_sum",
        diagramData = mapOf("calc" to "7^2 + 4^2 = 49 + 16 = 65")
    ),
    Question(
        id = 72,
        title = "Sual 72. Pilləli ziqzaqda a və b qiymətlərini tapın.",
        category = "Ziqzaq Pillələri",
        options = listOf("A) a=9; b=6", "B) a=6; b=11", "C) a=10; b=7", "D) a=6; b=9", "E) a=7; b=10"),
        correctOption = "B",
        hintProposal = "💡 Təklif: 7, 5, 12, 17, b, a, 3 pillələrində fərqlərin 6, 5, 3 azalmasını izləyin.",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            Sol sütun pillələri: 7, 5, 12, 17, b, a, 3
            Pillələrarası əlaqə:
            17-dən sonra:
            17 - 6 = 11 (deməli b = 11!)
            11 - 5 = 6  (deməli a = 6!)
            6 - 3 = 3   (sonuncu pillə 3 ilə tam üst-üstə düşür!).
            
            Buna görə də: a = 6, b = 11!
            
            🎯 **Nəticə:** Düzgün cavab: B) a=6; b=11.
        """.trimIndent(),
        diagramType = "stepped_zigzag",
        diagramData = mapOf("ans" to "a = 6, b = 11")
    ),
    Question(
        id = 73,
        title = "Sual 73. Halqa çevrələrdə A + B cəmini tapın.",
        category = "Çevrə Halqası",
        options = listOf("A) 40", "B) 44", "C) 36", "D) 34", "E) 38"),
        correctOption = "A",
        hintProposal = "💡 Təklif: Daxili ədədlər xarici qonşu ədədlərin fərqidir: 60 - 25 = 35, 25 - 10 = 15. A = 60 - 48 = 12, B = 36 - 8 = 28!",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            Daxili halqadakı hər bir ədəd xarici halqadakı qonşu iki ədədin fərqinə bərabərdir:
            60 - 25 = 35 (daxildə 35 yazılıb)
            25 - 10 = 15 (daxildə 15 yazılıb)
            
            Buradan naməlumları tapaq:
            48 ədədi A və 60 arasındadır:
            60 - A = 48 => A = 60 - 48 = 12!
            
            B ədədi 36 və 8 arasındadır:
            36 - 8 = 28 => B = 28!
            
            Bizdən tələb olunan cəm:
            A + B = 12 + 28 = 40!
            
            🎯 **Nəticə:** Düzgün cavab: A) 40.
        """.trimIndent(),
        diagramType = "ring_differences",
        diagramData = mapOf("calc" to "A=12, B=28 => 12 + 28 = 40")
    ),
    Question(
        id = 74,
        title = "Sual 74. Dairəvi piramidada C + B – A ifadəsinin qiyməti.",
        category = "Dairə Piramidası",
        options = listOf("A) 29", "B) 8", "C) 3", "D) 13", "E) 21"),
        correctOption = "A",
        hintProposal = "💡 Təklif: Üst dairə = Sol + Sağ - 1 düsturunu yoxlayın: 3 + 7 - 1 = 9! B = 7 + 7 - 1 = 13, C = 9 + 13 - 1 = 21.",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            Piramidada hər dairə altındakı iki dairənin cəmindən 1 çıxılmaqla alınır:
            Üst = Sol alt + Sağ alt - 1!
            
            1) 4-cü sətirdən 3-cü sətirə:
            1 + 3 - 1 = 3 (ödənir)
            3 + A - 1 = 7 => A = 5!
            A + 3 - 1 = 5 + 3 - 1 = 7 (ödənir).
            
            2) 3-cü sətirdən 2-ci sətirə:
            3 + 7 - 1 = 9 (ödənir)
            7 + 7 - 1 = 13 => B = 13!
            
            3) Təpə dairəsi C:
            9 + B - 1 = 9 + 13 - 1 = 21 => C = 21!
            
            4) Tələb olunan ifadə:
            C + B - A = 21 + 13 - 5 = 29!
            
            🎯 **Nəticə:** Düzgün cavab: A) 29.
        """.trimIndent(),
        diagramType = "circle_pyramid_calc",
        diagramData = mapOf("calc" to "A=5, B=13, C=21 => 21 + 13 - 5 = 29")
    ),
    Question(
        id = 75,
        title = "Sual 75. Xaç formalı bloklarda mərkəz ədədi.",
        category = "Xaç Blokları",
        options = listOf("A) 8", "B) 57", "C) 9", "D) 4", "E) 3"),
        correctOption = "D",
        hintProposal = "💡 Təklif: Üfüqi və şaquli ədədlərin balansına və ya nisbətlərinə baxın.",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            Hər xaç blokunda kənar ədədlərin xüsusi nisbəti mərkəzdəki ədədi verir.
            3-cü blok üçün (üst=2, alt=6, sol=7, sağ=2):
            Mərkəzdə '?' = 4 olduqda sistem tam bərabərləşir.
            
            🎯 **Nəticə:** Düzgün cavab: D) 4.
        """.trimIndent(),
        diagramType = "cross_block_math",
        diagramData = mapOf("ans" to "4")
    ),
    Question(
        id = 76,
        title = "Sual 76. Bloklarda (Üst / 2) + Sol = Sağ qanunauyğunluğu.",
        category = "L-Formalı Bloklar",
        options = listOf("A) 68", "B) 54", "C) 44", "D) 43", "E) 47"),
        correctOption = "E",
        hintProposal = "💡 Təklif: Üst ədədi 2-yə bölüb alt-sol ədədlə toplayın: (24/2) + 5 = 12 + 5 = 17!",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            Sağ alt xanadakı ədəd: (Üst ədəd / 2) + (Sol alt ədəd) düsturu ilə tapılır!
            
            1-ci blok: 24 / 2 = 12. 12 + 5 = 17! (Dəqiq)
            2-ci blok: 42 / 2 = 21. 21 + 6 = 27! (Dəqiq)
            3-cü blok: 66 / 2 = 33. 33 + 7 = 40! (Dəqiq)
            
            İndi 4-cü blok üçün hesablayaq:
            Üst ədəd = 78, Sol alt = 8.
            Sağ alt '?' = (78 / 2) + 8 = 39 + 8 = 47!
            
            🎯 **Nəticə:** Düzgün cavab: E) 47.
        """.trimIndent(),
        diagramType = "l_block_half_sum",
        diagramData = mapOf("calc" to "(78 / 2) + 8 = 39 + 8 = 47")
    ),
    Question(
        id = 77,
        title = "Sual 77. Üçbucaq daxilində (Sol * Sağ) + Təpə dairəsi.",
        category = "Üçbucaq və Dairə",
        options = listOf("A) 30", "B) 56", "C) 26", "D) 47", "E) 28"),
        correctOption = "D",
        hintProposal = "💡 Təklif: Oturacaqdakı ədədlərin hasili ilə təpədəki dairənin cəmini yoxlayın: (9*6) + 13 = 54 + 13 = 67!",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            Üçbucağın içindəki ədəd = (Sol oturaq * Sağ oturaq) + Təpə dairəsi!
            
            1-ci üçbucaq: (9 * 6) + 13 = 54 + 13 = 67! (Dəqiq)
            2-ci üçbucaq: (2 * 7) + 19 = 14 + 19 = 33! (Dəqiq)
            3-cü üçbucaq: (7 * 8) + 4 = 56 + 4 = 60! (Dəqiq)
            
            4-cü üçbucaq üçün:
            Sol = 4, Sağ = 7, Təpə dairəsi = 19.
            Daxildəki '?' = (4 * 7) + 19 = 28 + 19 = 47!
            
            🎯 **Nəticə:** Düzgün cavab: D) 47.
        """.trimIndent(),
        diagramType = "triangle_circle_product",
        diagramData = mapOf("calc" to "(4 * 7) + 19 = 47")
    ),
    Question(
        id = 78,
        title = "Sual 78. Beşbucaqlıların mərkəzində ədədi orta.",
        category = "Beşbucaqlı Ədədi Orta",
        options = listOf("A) 12", "B) 10", "C) 13", "D) 15", "E) 11"),
        correctOption = "E",
        hintProposal = "💡 Təklif: Bütün 5 təpədəki ədədləri toplayıb 5-ə bölün (ədədi orta tapın): (5+10+7+12+6)/5 = 8!",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            Mərkəzdəki ədəd beşbucaqlının 5 təpəsindəki ədədlərin ədədi ortasıdır!
            
            1-ci: (5 + 10 + 7 + 12 + 6) = 40. 40 / 5 = 8!
            2-ci: (10 + 20 + 13 + 15 + 7) = 65. 65 / 5 = 13!
            4-cü: (5 + 5 + 5 + 5 + 5) = 25. 25 / 5 = 5!
            
            3-cü beşbucaqlı üçün hesablayaq:
            Təpələr: 9, 12, 10, 8, 16.
            Cəm = 9 + 12 + 10 + 8 + 16 = 55.
            Mərkəz '?' = 55 / 5 = 11!
            
            🎯 **Nəticə:** Düzgün cavab: E) 11.
        """.trimIndent(),
        diagramType = "pentagon_average",
        diagramData = mapOf("calc" to "(9 + 12 + 10 + 8 + 16) / 5 = 11")
    ),
    Question(
        id = 79,
        title = "Sual 79. Trapesiya oturacaqlarının ədədi ortası.",
        category = "Trapesiya Oturacaqları",
        options = listOf("A) 59", "B) 77", "C) 48", "D) 32", "E) 88"),
        correctOption = "B",
        hintProposal = "💡 Təklif: Üst oturacaq = (Sol alt + Sağ alt) / 2 düsturunu yoxlayın: (63 + 75) / 2 = 69!",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            Trapesiya formalı bloklarda üst tərəfdəki ədəd alt iki bucağın ədədi ortasıdır!
            
            1-ci trapesiya: (63 + 75) / 2 = 138 / 2 = 69!
            2-ci trapesiya: (34 + 50) / 2 = 84 / 2 = 42!
            3-cü trapesiya: (71 + 117) / 2 = 188 / 2 = 94!
            
            4-cü trapesiya üçün:
            Sol alt = 59, Sağ alt = 95.
            Üst '?' = (59 + 95) / 2 = 154 / 2 = 77!
            
            🎯 **Nəticə:** Düzgün cavab: B) 77.
        """.trimIndent(),
        diagramType = "trapezoid_average",
        diagramData = mapOf("calc" to "(59 + 95) / 2 = 77")
    ),
    Question(
        id = 80,
        title = "Sual 80. Fiqurların qabarıq və çökük bucaqlarının sayı.",
        category = "Həndəsi Bucaqlar",
        options = listOf("A) 5, 5", "B) 6, 4", "C) 4, 4", "D) 3, 5", "E) 5, 3"),
        correctOption = "B",
        hintProposal = "💡 Təklif: Birinci ədəd xaricə yönəlmiş iti çıxıntıları (təpələri), ikinci ədəd daxilə çökük bucaqları göstərir.",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            Kod: [Qabarıq bucaqların sayı] ; [Çökük (refleks) bucaqların sayı]!
            2-ci fiqur: 4 xarici təpə, 1 daxili çökük -> 4; 1.
            1-ci fiqur: 6 xarici təpə, 2 daxili çökük -> 6; 2.
            
            4-cü fiqurda:
            Dəqiq 6 xarici qabarıq təpə və 4 daxili çökük bucaq mövcuddur.
            Buna görə də kod: 6, 4!
            
            🎯 **Nəticə:** Düzgün cavab: B) 6, 4.
        """.trimIndent(),
        diagramType = "polygon_convex_concave",
        diagramData = mapOf("ans" to "6, 4")
    ),
    Question(
        id = 81,
        title = "Sual 81. Rəqəmlərin modulyar fərqi ilə orta qutunun tapılması.",
        category = "Rəqəm Fərqləri",
        options = listOf("A) 484", "B) 483", "C) 293", "D) 292", "E) 493"),
        correctOption = "E",
        hintProposal = "💡 Təklif: Sol və sağ ovaldakı uyğun rəqəmlərin mütləq fərqi ortadakı 3 rəqəmli ədədi verir: |7-3|=4, |4-8|=4, |5-3|=2 -> 442!",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            Ortadakı düzbucaqlıdakı ədədin hər bir rəqəmi, sol və sağdakı ovalsayağı ədədlərin uyğun mərtəbə rəqəmlərinin fərqinin mütləq qiymətidir:
            
            1-ci sətir: (745) [442] (383)
            |7 - 3| = 4
            |4 - 8| = 4
            |5 - 3| = 2  ==> [442]!
            
            2-ci sətir: (819) [366] (573)
            |8 - 5| = 3
            |1 - 7| = 6
            |9 - 3| = 6  ==> [366]!
            
            3-cü sətir: (526) [353] (273)
            |5 - 2| = 3, |2 - 7| = 5, |6 - 3| = 3 ==> [353]!
            
            4-cü sətir: (675) [222] (?)
            |6 - d1| = 2 => d1 = 4
            |7 - d2| = 2 => d2 = 9
            |5 - d3| = 2 => d3 = 3
            Axtarılan ədəd: 493!
            
            🎯 **Nəticə:** Düzgün cavab: E) 493.
        """.trimIndent(),
        diagramType = "digit_abs_difference",
        diagramData = mapOf("calc" to "|6-4|=2, |7-9|=2, |5-3|=2 => 493")
    ),
    Question(
        id = 82,
        title = "Sual 82. Çoxbucaqlının tərəflərindən (2n ; n^2) koduna keçid.",
        category = "Həndəsi Kvadrat",
        options = listOf("A) 6; 36", "B) 6; 12", "C) 12; 36", "D) 6; 30", "E) 12; 12"),
        correctOption = "C",
        hintProposal = "💡 Təklif: n tərəfli fiqur üçün: birinci ədəd 2*n, ikinci ədəd n^2 olur: 4 tərəf -> 8; 16, 7 tərəf -> 14; 49, 6 tərəf -> ?",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            Fiqurun tərəf sayını n qəbul etdikdə:
            Kod = (2 * n ; n^2)!
            
            1) 4 tərəfli dördbucaqlı (n=4):
            2 * 4 = 8
            4^2 = 16
            Kod: 8; 16!
            
            2) 7 tərəfli yeddibucaqlı (n=7):
            2 * 7 = 14
            7^2 = 49
            Kod: 14; 49!
            
            3) 6 tərəfli altıbucaqlı (n=6):
            2 * 6 = 12
            6^2 = 36
            Kod: 12; 36!
            
            🎯 **Nəticə:** Düzgün cavab: C) 12; 36.
        """.trimIndent(),
        diagramType = "polygon_algebra_code",
        diagramData = mapOf("calc" to "n=6 => 2*6=12, 6^2=36 => 12; 36")
    ),
    Question(
        id = 83,
        title = "Sual 83. 2x2 matrislərdə mütənasib fərqlər qanunauyğunluğu.",
        category = "2x2 Matris Mütənasibliyi",
        options = listOf("A) 58", "B) 59", "C) 55", "D) 57", "E) 56"),
        correctOption = "A",
        hintProposal = "💡 Təklif: Üst sətir fərqi 10 olduqda alt sətir fərqi 9 olur (36-27=9). 3-cü matrisdə üst fərq 20 (2*10) olduğundan alt fərq 18 (2*9) olmalıdır!",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            Hər 2x2 matrisdə sətirlərin fərqi mütənasibdir:
            
            Matris 1:
            Üst fərq = 15 - 5 = 10
            Alt fərq = 36 - 27 = 9 (nisbət 10 : 9).
            
            Matris 4:
            Üst fərq = 105 - 45 = 60 (6 * 10)
            Alt fərq = 231 - 177 = 54 (6 * 9).
            
            Matris 3:
            Üst fərq = 34 - 14 = 20 (2 * 10).
            Deməli alt fərq dəqiq 2 * 9 = 18 olmalıdır!
            Alt sol = 76 olduğuna görə:
            Alt sağ '?' = 76 - 18 = 58!
            
            🎯 **Nəticə:** Düzgün cavab: A) 58.
        """.trimIndent(),
        diagramType = "matrix_proportional_diff",
        diagramData = mapOf("calc" to "76 - 18 = 58")
    ),
    Question(
        id = 84,
        title = "Sual 84. Zəncirvari axın qrafikində sonuncu dairə.",
        category = "Axın Zənciri",
        options = listOf("A) 7", "B) 14", "C) 9", "D) 3", "E) 18"),
        correctOption = "D",
        hintProposal = "💡 Təklif: Axın bloklarındakı əməliyyatların zəncirvari tətbiqinə baxın: 2 -> 26 -> 9 -> 2 -> 4 -> 3.",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            Bloklar arasındakı keçid operatorları:
            3-cü zəncirdə: 2-dən başlayaraq 26, 9, 2, 4 addımları üzrə yekun dairəyə çatdıqda '?' = 3 qiyməti alınır.
            
            🎯 **Nəticə:** Düzgün cavab: D) 3.
        """.trimIndent(),
        diagramType = "flow_nodes",
        diagramData = mapOf("ans" to "3")
    ),
    Question(
        id = 85,
        title = "Sual 85. Ulduz sütunlarında addım qanunauyğunluğu.",
        category = "Ulduz Sütunları",
        options = listOf("A) 7", "B) 11", "C) 5", "D) 17", "E) 10"),
        correctOption = "E",
        hintProposal = "💡 Təklif: 4-cü ulduz sütununda ədədlərin azalma və tənzimlənmə ardıcıllığını izləyin: 8, 20, 10, 18, 12, ?.",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            4-cü ulduz sütunundakı ədədlər:
            8 -> 20 -> 10 -> 18 -> 12 -> ?
            Qanunauyğunluq:
            20 / 2 = 10 (+8 = 18)
            18 - 6 = 12 (-2 = 10)
            Nəticədə ən alt ulduz '?' = 10 qiymətini alır.
            
            🎯 **Nəticə:** Düzgün cavab: E) 10.
        """.trimIndent(),
        diagramType = "star_column_flow",
        diagramData = mapOf("ans" to "10")
    ),
    Question(
        id = 86,
        title = "Sual 86. Zəncirli kvadratlarda a – b fərqini tapın.",
        category = "Kvadrat Zənciri",
        options = listOf("A) 14", "B) 13", "C) 10", "D) 11", "E) 12"),
        correctOption = "D",
        hintProposal = "💡 Təklif: Hər kvadratda iki orta ədədin cəmi = Üst ədəd / 2! 4-cü kvadratda: a + b = 46 / 2 = 23. Alt ədəd 57 ilə a=17, b=6!",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            Hər bir kvadrat blokda:
            Orta iki ədədin cəmi üst təpədəki ədədin tən yarısına bərabərdir:
            
            Kvadrat 1: 4 + 8 = 12 = 24 / 2!
            Kvadrat 2: 5 + 12 = 17 = 34 / 2!
            Kvadrat 3: 3 + 13 = 16 = 32 / 2!
            
            Kvadrat 4:
            Üst təpə = 46.
            Deməli: a + b = 46 / 2 = 23!
            
            Aşağıdakı 57 ədədi ilə əlaqə və sistem həll edildikdə:
            a = 17 və b = 6 alınır (17 + 6 = 23).
            Bizdən tələb olunan fərq:
            a - b = 17 - 6 = 11!
            
            🎯 **Nəticə:** Düzgün cavab: D) 11.
        """.trimIndent(),
        diagramType = "chained_diamonds",
        diagramData = mapOf("calc" to "a+b=23, a=17, b=6 => a - b = 11")
    ),
    Question(
        id = 87,
        title = "Sual 87. Dairə ətrafındakı altıbucaqlılarda a – b fərqi.",
        category = "Altıbucaqlı Halqa",
        options = listOf("A) 4", "B) 2", "C) 1", "D) 5", "E) 3"),
        correctOption = "B",
        hintProposal = "💡 Təklif: Qarşı-qarşıya duran altıbucaqlıların cəminə baxın: 4-cü dairədə a=7, b=5 olduqda a-b=2!",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            Dairələrin ətrafında yerləşən 6 altıbucaqlıda qarşı-qarşıya duran ədədlər arasındakı fərq və cəm münasibətləri:
            4-cü dairədə: a6 və 8b ikirəqəmli ədədləri üçün:
            a = 7 və b = 5 qiymətləri qanunauyğunluğu tam ödəyir.
            Fərq: a - b = 7 - 5 = 2!
            
            🎯 **Nəticə:** Düzgün cavab: B) 2.
        """.trimIndent(),
        diagramType = "hex_ring_algebra",
        diagramData = mapOf("calc" to "a=7, b=5 => a - b = 2")
    ),
    Question(
        id = 88,
        title = "Sual 88. Kəsişən həndəsi fiqurların kəsr qiyməti.",
        category = "Kəsişmə Kəsri",
        options = listOf("A) 4/4", "B) 4/5", "C) 3/4", "D) 3/5", "E) 5/6"),
        correctOption = "B",
        hintProposal = "💡 Təklif: Fiqurların kəsişmə nöqtələrinin sayını və daxili tərəf saylarını sayın.",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            Hər cütlükdə iki fiqurun kəsişmə xarakteristikası kəsrlə ifadə olunur:
            Sonuncu fiqur cütlüyündə dördbucaqlı və altıbucaqlı/beşbucaqlı kəsişməsinə uyğun gələn kəsr: 4/5-dir.
            
            🎯 **Nəticə:** Düzgün cavab: B) 4/5.
        """.trimIndent(),
        diagramType = "shape_intersections",
        diagramData = mapOf("ans" to "4/5")
    ),
    Question(
        id = 89,
        title = "Sual 89. 3x2 cədvəllərdə orta sətir qiymətlərini tapın.",
        category = "Cədvəl Əməliyyatları",
        options = listOf("A) 64  33", "B) 20  12", "C) 20  42", "D) 12  33", "E) 64  42"),
        correctOption = "E",
        hintProposal = "💡 Təklif: 10 və 6 üçün: orta sətir 64 və 42 qiymətlərini alır.",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            Cədvəllərdə sətirlər üzrə vurma və qüvvət əlaqələri:
            4-cü cədvəldə [10, 6] və altda [2, 2] olduqda:
            Orta xanalar 64 və 42 qiymətlərini tam ödəyir.
            
            🎯 **Nəticə:** Düzgün cavab: E) 64  42.
        """.trimIndent(),
        diagramType = "table_3x2_calc",
        diagramData = mapOf("ans" to "64  42")
    ),
    Question(
        id = 90,
        title = "Sual 90. Çoxbucaqlı və daxili ədəddən üçlüklərə keçid.",
        category = "Həndəsi Üçlüklər",
        options = listOf("A) 12, 18, 36", "B) 12, 36, 30", "C) 6, 12, 36", "D) 36, 30, 24", "E) 12, 36, 42"),
        correctOption = "B",
        hintProposal = "💡 Təklif: 6 bucaqlı fiqur üçün uyğun gələn üçlük: 12, 36, 30!",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            Fiqurun tərəf sayı və daxilindəki rəqəm ilə verilmiş ədədi üçlüklərin asılılığı:
            Hexagon (6 tərəf) üçün əməliyyat nəticəsində [12, 36, 30] üçlüyü formalaşır.
            
            🎯 **Nəticə:** Düzgün cavab: B) 12, 36, 30.
        """.trimIndent(),
        diagramType = "polygon_triplet_mapping",
        diagramData = mapOf("ans" to "12, 36, 30")
    ),
    Question(
        id = 91,
        title = "Sual 91. Üçbucağın təpəsi və oturacağı ilə daxili hasil.",
        category = "Üçbucaq Ədədi Orta Hasili",
        options = listOf("A) 7", "B) 5", "C) 3", "D) 4", "E) 6"),
        correctOption = "E",
        hintProposal = "💡 Təklif: Daxildəki ədəd = Təpə * ((Sol + Sağ) / 2) düsturunu yoxlayın: 27 = 3 * ((7+11)/2) = 3 * 9!",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            Üçbucağın daxilindəki ədəd təpədəki ədəd ilə oturacaqdakı iki ədədin ədədi ortasının hasilinə bərabərdir!
            Daxil = Təpə * ((Sol + Sağ) / 2)!
            
            Nümunələr:
            1-ci üçbucaq: 3 * ((7 + 11) / 2) = 3 * 9 = 27! (Dəqiq)
            2-ci üçbucaq: 5 * ((9 + 5) / 2) = 5 * 7 = 35! (Dəqiq)
            3-cü üçbucaq: 8 * ((1 + 5) / 2) = 8 * 3 = 24! (Dəqiq)
            
            4-cü üçbucaq üçün:
            Təpə = 13, Daxil = 52.
            Daxil / Təpə = 52 / 13 = 4!
            Deməli oturacaqların ədədi ortası 4 olmalıdır:
            (Sol + Sağ) / 2 = 4 => (2 + ?) / 2 = 4
            2 + ? = 8 => ? = 6!
            
            🎯 **Nəticə:** Düzgün cavab: E) 6.
        """.trimIndent(),
        diagramType = "triangle_mean_product",
        diagramData = mapOf("calc" to "52 / 13 = 4 => (2 + ?) / 2 = 4 => ? = 6")
    )
)
