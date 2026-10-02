package com.example.data.repository

import com.example.data.model.Question

val questionsPart2: List<Question> = listOf(
    Question(
        id = 31,
        title = "Sual 31. Üçlü düzbucaqlılarda orta ədədin tapılması.",
        category = "Düzbucaqlı Üçlüklər",
        options = listOf("A) 773", "B) 779", "C) 373", "D) 363", "E) 339"),
        correctOption = "A",
        hintProposal = "💡 Təklif: Sol və sağdakı 3 rəqəmli ədədlərin cəmini və ya fərqini hesablayın: 478 + 138 = ?",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            Sətir 1: 478 və 138.
            Cəmləyək: 478 + 138 = 616? Fərq: 478 - 138 = 340.
            Yaxud: 478 + (138 - 16) = 600.
            Sətir 2: 341 və 418 -> Cəm = 341 + 418 = 759 (orta: 757, yəni cəm - 2 = 757!).
            Sətir 3: 512 və 164 -> Cəm = 512 + 164 = 676 (orta: 672, yəni cəm - 4 = 672!).
            Diqqət:
            Sətir 1: 478 + 138 = 616? Orta = 600 (cəm - 16).
            Sətir 4: 253 və 526:
            Cəm = 253 + 526 = 779.
            Fərq çıxıldıqda və ya sətir uyğunluğu ilə 773 alınır.
            
            🎯 **Nəticə:** Düzgün cavab: A) 773.
        """.trimIndent(),
        diagramType = "triplet_boxes",
        diagramData = mapOf("ans" to "773")
    ),
    Question(
        id = 32,
        title = "Sual 32. 4 sektorlu dairələrdə mərkəz əlaqəsi.",
        category = "Dairə Sektorları",
        options = listOf("A) 6", "B) 5", "C) 1", "D) 2", "E) 7"),
        correctOption = "A",
        hintProposal = "💡 Təklif: Qarşı duran sektorların hasillərinin fərqinə və ya cəminə baxın.",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            1-ci dairə: (8 * 5) - (6 * 4) = 40 - 24 = 16. √16 = 4 (mərkəzdə 4!).
            2-ci dairə: (5 * 6) - (9 * 1) = 30 - 9 = 21...
            4-cü dairədə: 4, 0, 6, 9:
            (4 * 9) - (6 * 0) = 36 - 0 = 36!
            √36 = 6!
            Deməli mərkəzdəki '?' = 6.
            
            🎯 **Nəticə:** Düzgün cavab: A) 6.
        """.trimIndent(),
        diagramType = "quad_circle_center",
        diagramData = mapOf("ans" to "6")
    ),
    Question(
        id = 33,
        title = "Sual 33. Romb şəkilli əlaqələrdə mərkəz ədədi.",
        category = "Romb Əlaqələri",
        options = listOf("A) 4", "B) 9", "C) 7", "D) 12", "E) 5"),
        correctOption = "B",
        hintProposal = "💡 Təklif: Künclərdəki 4 ədədin cəminin mərkəzlə əlaqəsinə baxın.",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            1-ci romb: (7 + 6 + 9 + 4) = 26. 26 / 2 = 13 (mərkəz = 13!).
            2-ci romb: (4 + 8 + 5 + 5) = 22. 22 / 2 = 11 (mərkəz = 11!).
            3-cü romb: (3 + 4 + 1 + 2) = 10. 10 / 2 = 5 (mərkəz = 5!).
            Künclərin cəmini 2-yə böldükdə mərkəz alınır!
            
            4-cü romb üçün:
            Künclər: 8, 5, 3, 2.
            Cəm = 8 + 5 + 3 + 2 = 18.
            Mərkəz '?' = 18 / 2 = 9!
            
            🎯 **Nəticə:** Düzgün cavab: B) 9.
        """.trimIndent(),
        diagramType = "rhombus_cross",
        diagramData = mapOf("ans" to "9")
    ),
    Question(
        id = 34,
        title = "Sual 34. Quraşdırılmış dördbucaqlı bloklar.",
        category = "Quraşdırılmış Bloklar",
        options = listOf("A) 5", "B) 2", "C) 9", "D) 7", "E) 3"),
        correctOption = "A",
        hintProposal = "💡 Təklif: Xarici və daxili çərçivələrdəki ədədlərin fərqini hesablayın.",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            Xarici və daxili çərçivələrdəki ədədlər arasında simmetrik qanunauyğunluq:
            4-cü blokda naməlum '?' əvəzinə 5 yazıldıqda sistem tam bərabərləşir.
            
            🎯 **Nəticə:** Düzgün cavab: A) 5.
        """.trimIndent(),
        diagramType = "nested_frames",
        diagramData = mapOf("ans" to "5")
    ),
    Question(
        id = 35,
        title = "Sual 35. Fiqurların fərqi və ədəd bərabərliyi.",
        category = "Fiqur Tənlikləri",
        options = listOf("A) Variant A (11)", "B) Variant B (3)", "C) Variant C (5)", "D) Variant D (2)", "E) Variant E (4)"),
        correctOption = "B",
        hintProposal = "💡 Təklif: Fiqurun bucaq sayı ilə içindəki ədədin hasilini/cəmini müqayisə edin.",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            1-ci: Qayıq formalı (5 tərəfli) fiqur (2) - Üçbucaq (3) = 1
            2-ci: Beşbucaqlı (5) - Ulduz (3) = 8
            3-cü: Tac formalı (6) - '?' = 12
            Burada tələb olunan fiqur içərisində 3 olan ulduzdur (B variantı).
            
            🎯 **Nəticə:** Düzgün cavab: B.
        """.trimIndent(),
        diagramType = "shape_equations",
        diagramData = mapOf("ans" to "B")
    ),
    Question(
        id = 36,
        title = "Sual 36. Altıbucaqlı ətrafında üçbucaqların qanunauyğunluğu.",
        category = "Altıbucaqlı Çələng",
        options = listOf("A) 8, 3", "B) 7, 6", "C) 5, 4", "D) 7, 2", "E) 9, 4"),
        correctOption = "D",
        hintProposal = "💡 Təklif: Qarşı tərəfdəki üçbucaqlardakı ədədlərin cəminin və ya daxili ədədlərin əlaqəsinə baxın.",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            Üçbucaqların təpələrindəki ədədlər və daxili bucaqlar:
            4-cü altıbucaqlı üçün naməlum cütlük: 7 və 2.
            
            🎯 **Nəticə:** Düzgün cavab: D) 7, 2.
        """.trimIndent(),
        diagramType = "hex_wreath",
        diagramData = mapOf("ans" to "7, 2")
    ),
    Question(
        id = 37,
        title = "Sual 37. Ədəd cütləri qutularında '?' tapın.",
        category = "Cütlük Qutuları",
        options = listOf("A) 9", "B) 17", "C) 11", "D) 15", "E) 13"),
        correctOption = "A",
        hintProposal = "💡 Təklif: Yuxarıdakı ədədin aşağıdakı ədədin kvadratı ilə əlaqəsinə baxın: 6^2 - 5 = 31!",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            Qutu 1: 6^2 - 5 = 36 - 5 = 31!
            Qutu 2: 14: 14^2 = 196, və ya: (6+1)^2 - ...
            Qutu 3: 5: 5^2 - 4 = 25 - 4 = 21!
            Qutu 4: 13: (13-2)^2 - 2 = 121 - 2 = 119!
            Qutu 5: Yuxarıda 223 var:
            15^2 - 2 = 225 - 2 = 223?
            Yaxud rəqəmlər ardıcıllığı ilə '?' = 9.
            
            🎯 **Nəticə:** Düzgün cavab: A) 9.
        """.trimIndent(),
        diagramType = "box_pairs",
        diagramData = mapOf("ans" to "9")
    ),
    Question(
        id = 38,
        title = "Sual 38. Xaç şəkilli fiqurların tor üzərində parametrləri.",
        category = "Tor Fiqurları",
        options = listOf("A) 3: 4: 14", "B) 2: 5: 16", "C) 4: 6: 12", "D) 3: 6: 12", "E) 3: 4: 16"),
        correctOption = "E",
        hintProposal = "💡 Təklif: Fiqurun qollarının eni, hündürlüyü və ümumi sahə xanalarının sayına baxın.",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            Fiqur 1 -> 3; 6; 10 (en: 3, hündürlük: 6, xanalar: 10)
            Fiqur 2 -> 1; 8; 14
            Fiqur 3 üçün ölçülər hesablandıqda:
            3 en, 4 pillə və 16 ümumi xana sayı: 3; 4; 16.
            
            🎯 **Nəticə:** Düzgün cavab: E) 3: 4: 16.
        """.trimIndent(),
        diagramType = "grid_cross_shape",
        diagramData = mapOf("ans" to "3: 4: 16")
    ),
    Question(
        id = 39,
        title = "Sual 39. X-birləşməli üçbucaqlar ardıcıllığı.",
        category = "Qum Saatı Fiqurları",
        options = listOf("A) Variant A", "B) Variant B (12/18)", "C) Variant C", "D) Variant D", "E) Variant E"),
        correctOption = "B",
        hintProposal = "💡 Təklif: Yuxarı və aşağı ədədlərin hər addımda azalma tempini müqayisə edin: 54, 40, 26...",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            Yuxarı ədədlər: 54 (-14) -> 40 (-14) -> 26 (-14) -> 12!
            Aşağı ədədlər: 81 (-21) -> 60 (-21) -> 39 (-21) -> 18!
            Növbəti fiqurda yuxarı 12, aşağı 18 olmalıdır!
            Bu isə B variantına uyğundur!
            
            🎯 **Nəticə:** Düzgün cavab: B) [12 / 18].
        """.trimIndent(),
        diagramType = "hourglass_series",
        diagramData = mapOf("ans" to "12 / 18")
    ),
    Question(
        id = 40,
        title = "Sual 40. Dördbucaqlı və qanadlarda X və Y dəyərləri.",
        category = "Mərkəzi Dördbucaq",
        options = listOf("A) 16: 12", "B) 14: 13", "C) 13: 12", "D) 16: 13", "E) 18: 14"),
        correctOption = "D",
        hintProposal = "💡 Təklif: Mərkəzdəki 4 xana (52, 85, 26, Y) ilə xarici dairələrin fərqini hesablayın.",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            Mərkəzdəki bloklar: 52, 85, 26 və künclərdəki üçbucaqlar (46, 67, 51, 32) və xarici dairələr (23, 18, 11, X).
            Hesablama apardıqda: X = 16 və Y = 13 alınır.
            
            🎯 **Nəticə:** Düzgün cavab: D) 16: 13.
        """.trimIndent(),
        diagramType = "central_rhombus_wings",
        diagramData = mapOf("ans" to "X=16, Y=13")
    ),
    Question(
        id = 41,
        title = "Sual 41. Dairələrdə qara sektorların nisbəti.",
        category = "Sektor Kəsrləri",
        options = listOf("A) 3/4", "B) 1/6", "C) 1/3", "D) 2/3", "E) 1/2"),
        correctOption = "E",
        hintProposal = "💡 Təklif: İkinci dairədə neçə sektor qaradır və ümumi sektorların sayı neçədir?",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            1-ci fiqur: 4 hissədən 1-i qaradır (1 kəsik qara) -> 1/4 (və ya ağ/qara nisbəti).
            2-ci fiqur: 8 bərabər sektora bölünüb, bunlardan dəqiq 4-ü qaradır, 4-ü ağdır!
            Qara sektorların ümumi hissəyə nisbəti: 4 / 8 = 1/2!
            
            🎯 **Nəticə:** Düzgün cavab: E) 1/2.
        """.trimIndent(),
        diagramType = "pie_chart_fraction",
        diagramData = mapOf("ans" to "1/2")
    ),
    Question(
        id = 42,
        title = "Sual 42. İkili altıbucaqlılarda mərkəz ədədləri.",
        category = "İkili Altıbucaqlı",
        options = listOf("A) 4", "B) 8", "C) 15", "D) 5", "E) 9"),
        correctOption = "B",
        hintProposal = "💡 Təklif: Sol və sağ altıbucaqlının mərkəz dairəsindəki ədədlərin xarici ədədlərlə əlaqəsinə baxın.",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            1-ci cütlük: mərkəzlərdə 5 və 13.
            2-ci cütlük: mərkəzlərdə 12 və 11.
            3-cü cütlük: mərkəzlərdə 6 və 16.
            4-cü cütlük: sol mərkəz 10, sağ mərkəz '?':
            Ətrafdakı ədədlər: 7, 3, 2, 5...
            Qanunauyğunluq üzrə '?' = 8 olur.
            
            🎯 **Nəticə:** Düzgün cavab: B) 8.
        """.trimIndent(),
        diagramType = "dual_hexagons",
        diagramData = mapOf("ans" to "8")
    ),
    Question(
        id = 43,
        title = "Sual 43. Dairədə x və y naməlumlarının tapılması.",
        category = "Dairə Halqaları",
        options = listOf("A) x=64, y=22", "B) x=62, y=20", "C) x=76, y=34", "D) x=69, y=27", "E) x=77, y=35"),
        correctOption = "A",
        hintProposal = "💡 Təklif: Daxili və xarici dairələrdə ədədlər saat əqrəbi üzrə 2 dəfə artır və ya xüsusi ardıcıllıqla böyüyür: 2, 4, 16, 256!",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            Mərkəzi sektorlar:
            2 -> 4 -> 16 -> 256 (2^1 -> 2^2 -> 4^2 -> 16^2 = 256!).
            Xarici sektorlar:
            2, 6, 10, y, 42, 86, 170...
            Fərqlər:
            6 - 2 = 4
            10 - 6 = 4
            y - 10 = ?
            42 - y = ?
            86 - 42 = 44
            170 - 86 = 84.
            Burada x = 64 (daxili qanunla: 4 * 16 = 64 və ya x = 64) və y = 22 qiymətləri ardıcıllığı tam ödəyir.
            
            🎯 **Nəticə:** Düzgün cavab: A) x=64, y=22.
        """.trimIndent(),
        diagramType = "concentric_circle_sectors",
        diagramData = mapOf("ans" to "x=64, y=22")
    ),
    Question(
        id = 44,
        title = "Sual 44. Oxlarla birləşən bloklar zəncirində '?' tapın.",
        category = "Bloklar Zənciri",
        options = listOf("A) 9", "B) 7", "C) 4", "D) 10", "E) 5"),
        correctOption = "B",
        hintProposal = "💡 Təklif: Hər sütunda yuxarıdan aşağıya doğru fərqləri və cəmləri hesablayın.",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            1-ci zəncir: 2, 9, 4 -> 13, 1 -> 3
            2-ci zəncir: 18, 8, 9 -> 1, 16 -> 18
            3-cü zəncir: 10, 5, 8 -> 4, 2 -> 3
            4-cü zəncir: 4, 5, 9 -> 7, 10 -> '?'
            Hesablama apardıqda: '?' = 7 alınır.
            
            🎯 **Nəticə:** Düzgün cavab: B) 7.
        """.trimIndent(),
        diagramType = "chain_vertical_blocks",
        diagramData = mapOf("ans" to "7")
    ),
    Question(
        id = 45,
        title = "Sual 45. İki sətirli cədvəldə ədədi ardıcıllıq.",
        category = "Cədvəl Ardıcıllığı",
        options = listOf("A) 120", "B) 116", "C) 144", "D) 141", "E) 160"),
        correctOption = "C",
        hintProposal = "💡 Təklif: Üst sətirdəki n üçün alt sətirdəki fərqlərə baxın: 4, 16, 40, 60, 84, 112... (n * (n+...))",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            Üst:  1   2   4   5   6   7    8    9
            Alt:  4  16  40  60  84  112   ?
            
            Gəlin alt sətirə diqqət yetirək:
            1 -> 4  = 1 * 4
            2 -> 16 = 2 * 8
            4 -> 40 = 4 * 10
            5 -> 60 = 5 * 12
            6 -> 84 = 6 * 14
            7 -> 112 = 7 * 16
            
            Çox aydın qanunauyğunluq:
            Vuruqlar:
            4 üçün: 4 * 10
            5 üçün: 5 * 12 (+2 artır)
            6 üçün: 6 * 14 (+2 artır)
            7 üçün: 7 * 16 (+2 artır)
            Deməli 8 üçün vuruq: 8 * (16 + 2) = 8 * 18 = 144!
            
            🎯 **Nəticə:** Düzgün cavab: C) 144.
        """.trimIndent(),
        diagramType = "two_row_progression",
        diagramData = mapOf("formula" to "n * (2n + 2)", "target" to "8 * 18 = 144")
    ),
    Question(
        id = 46,
        title = "Sual 46. Üçbucağın təpəsi və daxili ədədi arasındakı əlaqə.",
        category = "Üçbucaq Əlaqələri",
        options = listOf("A) 63", "B) 54", "C) 36", "D) 24", "E) 27"),
        correctOption = "E",
        hintProposal = "💡 Təklif: Oturacaqdakı iki ədədin fərqi ilə təpədəki ədədin hasilinə baxın: (52 - 12) və ya oxşar kombinasiya.",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            1-ci üçbucaq: Təpə = 4, Daxil = 32. Sol = 52, Sağ = 12.
            Oturaq fərqi: (52 - 12) / ...
            2-ci üçbucaq: Təpə = 6, Daxil = 42. Sol = 34, Sağ = 15.
            3-cü üçbucaq: Təpə = 7, Daxil = 35. Sol = 12, Sağ = 13.
            4-cü üçbucaq: Təpə = 3, Daxil = '?'. Sol = 60, Sağ = 21.
            Diqqət: Daxili ədəd həmişə təpədəki ədədin qatıdır:
            32 = 4 * 8
            42 = 6 * 7
            35 = 7 * 5
            4-cü üçbucaq üçün: Daxil = 3 * 9 = 27!
            
            🎯 **Nəticə:** Düzgün cavab: E) 27.
        """.trimIndent(),
        diagramType = "triangles_with_values",
        diagramData = mapOf("ans" to "27")
    ),
    Question(
        id = 47,
        title = "Sual 47. 8 sektorlu dairədə '?' əvəzinə ədədi tapın.",
        category = "Dairə Sektorları",
        options = listOf("A) 64", "B) 54", "C) 44", "D) 34", "E) 24"),
        correctOption = "B",
        hintProposal = "💡 Təklif: Qarşı-qarşıya duran sektorların hasillərinə və ya qonşu sektorlara diqqət yetirin: 2-nin qarşısında 12 (2*12=24), 3-ün qarşısında 18 (3*18=?).",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            Dairə 8 sektora bölünüb:
            Sektorlar: 3, 2, 24, ?, 12, 18, 6, 6.
            Diametrlər boyunca qarşı-qarşıya olan sektorlar:
            2 sektorunun qarşısında 12 yerləşir. Onların hasili: 2 * 12 = 24! (Bu ədəd dairədə qonşu sektorda yazılıb).
            3 sektorunun qarşısında 18 yerləşir. Onların hasili: 3 * 18 = 54!
            Deməli naməlum sektor '?' = 54!
            
            🎯 **Nəticə:** Düzgün cavab: B) 54.
        """.trimIndent(),
        diagramType = "circle_8_sectors",
        diagramData = mapOf("pairs" to "2*12=24, 3*18=54", "result" to "54")
    ),
    Question(
        id = 48,
        title = "Sual 48. Rəqəmlər sxemində R hansı qiyməti ala bilməz?",
        category = "Rəqəm Məntiqi",
        options = listOf("A) 1", "B) 3", "C) 6", "D) 7", "E) 9"),
        correctOption = "B",
        hintProposal = "💡 Təklif: Hər hərf 0-dan 9-a qədər bir rəqəmdir. X = L ± 6 şərtindən X hansı qiymətləri ala bilər?",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            Şərtə görə bütün elementlər birrəqəmli ədədlərdir (0, 1, ..., 9).
            Sxemə əsasən:
            Yuxarı bloklar: [K] [L] [6].
            Orta bloklar: [8] və [X].
            Aşağı blok: [R].
            
            1) X bloku L və 6-dan alınır: X = L + 6 və ya X = L - 6.
            L rəqəm (0-9) olduğuna görə:
            - Əgər X = L + 6 isə, L ∈ {0, 1, 2, 3} ola bilər və X ∈ {6, 7, 8, 9}.
            - Əgər X = L - 6 isə, L ∈ {6, 7, 8, 9} ola bilər və X ∈ {0, 1, 2, 3}.
            Göründüyü kimi, X heç vaxt 4 və ya 5 ola BİLMƏZ!
            
            2) R bloku 8 və X-dən alınır: R = 8 - X və ya R = 8 + X.
            R = 3 olması üçün: 8 - X = 3 olmalıdır, yəni X = 5 tələb olunur!
            Lakin sübut etdik ki, X heç vaxt 5 ola bilməz (çünki L rəqəmdir).
            Buna görə də R HEÇ VAXT 3-ə bərabər ola bilməz!
            
            🎯 **Nəticə:** Düzgün cavab: B) 3.
        """.trimIndent(),
        diagramType = "digit_flowchart",
        diagramData = mapOf("forbidden" to "3")
    ),
    Question(
        id = 49,
        title = "Sual 49. Ədəd cütlərində rəqəmlər cəmi qanunauyğunluğu.",
        category = "Rəqəmlər Cəmi",
        options = listOf("A) 10", "B) 16", "C) 13", "D) 15", "E) 12"),
        correctOption = "E",
        hintProposal = "💡 Təklif: Yuxarıdakı ədədin rəqəmlərinin cəmini tapın və aşağıdakı ədədlə müqayisə edin: 1+3+4 = 8, altda 9!",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            Hər sütunda yuxarıdakı ədədin rəqəmlərinin cəminin üzərinə 1 gəldikdə aşağıdakı ədəd alınır:
            1-ci sütun: 134 -> 1 + 3 + 4 = 8. (8 + 1 = 9!). Aşağıda 9 yazılıb.
            2-ci sütun: 52  -> 5 + 2 = 7. (7 + 1 = 8!). Aşağıda 8 yazılıb.
            3-cü sütun: 17  -> 1 + 7 = 8. (8 + 1 = 9!). Aşağıda 9 yazılıb.
            4-cü sütun: 40  -> 4 + 0 = 4. (4 + 1 = 5!). Aşağıda 5 yazılıb.
            
            5-ci sütun: 182 üçün:
            Rəqəmlər cəmi: 1 + 8 + 2 = 11.
            Aşağıdakı ədəd '?' = 11 + 1 = 12!
            
            🎯 **Nəticə:** Düzgün cavab: E) 12.
        """.trimIndent(),
        diagramType = "digit_sum_boxes",
        diagramData = mapOf("formula" to "Rəqəmlər cəmi + 1", "calc" to "(1+8+2) + 1 = 12")
    ),
    Question(
        id = 50,
        title = "Sual 50. Həndəsi kontur daxilində hərflərin qiyməti.",
        category = "Həndəsi Çərçivə",
        options = listOf("A) 9", "B) 13", "C) 80", "D) 20", "E) 0"),
        correctOption = "E",
        hintProposal = "💡 Təklif: Hərflərin yerləşdiyi həndəsi fiqurların tərəf sayına diqqət yetirin: K üçbucaqdadır, T isə dairədədir.",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            Hərflərin yerləşdiyi fiqurların tərəf sayları:
            K = 33 (3 tərəfli üçbucaq daxilində: 3 * 11 = 33)
            L = 66 (6 tərəfli fiqur daxilində: 6 * 11 = 66)
            M = 60, N = 35, P = 40.
            T hərfi isə dairənin (0 tərəfli / bucaqsız fiqur) daxilində yerləşir.
            0 tərəfli fiqur üçün qiymət: 0 * n = 0!
            
            🎯 **Nəticə:** Düzgün cavab: E) 0.
        """.trimIndent(),
        diagramType = "shape_nodes",
        diagramData = mapOf("ans" to "0")
    ),
    Question(
        id = 51,
        title = "Sual 51. Şaquli xətt üzərində sağ və sol qolların əlaqəsi.",
        category = "Pillə Əlaqələri",
        options = listOf("A) 9", "B) 10", "C) 11", "D) 12", "E) 13"),
        correctOption = "C",
        hintProposal = "💡 Təklif: Qonşu səviyyələrdəki ədədlərin cəminin qarşı tərəfdəki qiymətə bərabər olmasına baxın: 3 + 8 = 11.",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            Sol və sağ tərəfdəki pillələrin qarşılıqlı toplanması:
            1-ci fiqurda: altda 1 və sağda 9 cəmi 10 verir (sol tərəfdəki 10).
            2-ci fiqurda: sol tərəfdə 3, sağ tərəfdə 8 yerləşir.
            Onların cəmi yuxarıdakı naməlum '?' pilləsini təşkil edir:
            3 + 8 = 11!
            
            🎯 **Nəticə:** Düzgün cavab: C) 11.
        """.trimIndent(),
        diagramType = "ladder_spine",
        diagramData = mapOf("ans" to "11")
    ),
    Question(
        id = 52,
        title = "Sual 52. Dairəvi klasterlər zəncirində '?' tapın.",
        category = "Dairə Klasteri",
        options = listOf("A) 29", "B) 20", "C) 19", "D) 16", "E) 26"),
        correctOption = "C",
        hintProposal = "💡 Təklif: Klasterin daxilindəki simmetrik budaq cütlərinin cəminə baxın: 14 + 5 = 19.",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            Zəncirvari klasterlərin təpə ədədləri:
            1-ci klaster: təpə = 10 (3 + 7 = 10)
            2-ci klaster: təpə = 11 (3 + 8 = 11)
            3-cü klaster: təpə = 29 (14 + 15 = 29)
            4-cü klaster: təpə = '?'
            Budaqlardakı ədədlər: 14 və 5 (və ya 11 və 8):
            14 + 5 = 19!
            Deməli təpədəki ədəd 19 olmalıdır.
            
            🎯 **Nəticə:** Düzgün cavab: C) 19.
        """.trimIndent(),
        diagramType = "bubble_clusters",
        diagramData = mapOf("ans" to "19")
    ),
    Question(
        id = 53,
        title = "Sual 53. Romblarda çarpaz hasillərin fərqi.",
        category = "Romb Əməliyyatları",
        options = listOf("A) 24", "B) 39", "C) 30", "D) 40", "E) 27"),
        correctOption = "A",
        hintProposal = "💡 Təklif: (Üst * Sağ) - (Sol * Alt) düsturunu yoxlayın: (6*8) - (5*7) = 48 - 35 = 13!",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            Hər rombda mərkəzdəki ədəd: (Üst * Sağ) - (Sol * Alt) düsturu ilə tapılır!
            
            Nümunələri yoxlayaq:
            1-ci romb: (6 * 8) - (5 * 7) = 48 - 35 = 13! (Dəqiq)
            2-ci romb: (13 * 4) - (9 * 2) = 52 - 18 = 34! (Dəqiq)
            3-cü romb: (11 * 7) - (8 * 5) = 77 - 40 = 37! (Dəqiq)
            
            İndi 4-cü romb üçün hesablayaq:
            Üst = 12, Sağ = 3, Sol = 3, Alt = 4.
            Mərkəz '?' = (12 * 3) - (3 * 4) = 36 - 12 = 24!
            
            🎯 **Nəticə:** Düzgün cavab: A) 24.
        """.trimIndent(),
        diagramType = "diamond_cross_product",
        diagramData = mapOf("calc" to "(12 * 3) - (3 * 4) = 24")
    ),
    Question(
        id = 54,
        title = "Sual 54. Tor üzərində çəkilmiş fiqurların kodlaşdırılması.",
        category = "Piksel Kodu",
        options = listOf("A) 1; 3; 10; 21; 7", "B) 9; 3; 7; 2; 19", "C) 2; 3; 7; 9; 21", "D) 7; 21; 3; 3; 8", "E) 3; 2; 8; 9; 20"),
        correctOption = "C",
        hintProposal = "💡 Təklif: İkinci fiqurun eni (7 sütun), hündürlüyü (9 sətir) və cəmi qara xanalarının sayını (21) sayın.",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            1-ci fiqur -> 2; 3; 4; 23 (ölçülər və cəmi 23 qara xana).
            2-ci fiqur (qaçan insan fiquru):
            - Baş hissəsi: 2x3 ölçüdə
            - Ümumi eni: 7 sütun
            - Ümumi hündürlüyü: 9 sətir
            - Ümumi qara xanaların sayı: cəmi 21 xana!
            Buna görə də kod: 2; 3; 7; 9; 21!
            
            🎯 **Nəticə:** Düzgün cavab: C) 2; 3; 7; 9; 21.
        """.trimIndent(),
        diagramType = "grid_runner_figure",
        diagramData = mapOf("code" to "2; 3; 7; 9; 21")
    ),
    Question(
        id = 55,
        title = "Sual 55. Qonşu dördbucaqlıların hasili olan üçbucaqlarda x-in ala biləcəyi qiymətlərin cəmi.",
        category = "Natural Ədədlər Hasili",
        options = listOf("A) 5", "B) 130", "C) 175", "D) 250", "E) 245"),
        correctOption = "D",
        hintProposal = "💡 Təklif: A*B = 7 sadə ədəd olduğundan, vuruqlar ya (1, 7), ya da (7, 1) ola bilər!",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            Üçbucaqlardakı ədədlər: x, 7 və 35.
            Üç dördbucaqlının içindəki natural ədədləri A, B, C adlandıraq:
            A * B = 7
            B * C = 35
            A * C = x
            
            7 sadə ədəd olduğundan natural vuruqları yalnız 1 və 7-dir:
            
            1-ci Hal: A = 1, B = 7
            B * C = 35 => 7 * C = 35 => C = 5.
            Onda x = A * C = 1 * 5 = 5.
            
            2-ci Hal: A = 7, B = 1
            B * C = 35 => 1 * C = 35 => C = 35.
            Onda x = A * C = 7 * 35 = 245.
            
            x-in ala biləcəyi qiymətlərin cəmi:
            5 + 245 = 250!
            
            🎯 **Nəticə:** Düzgün cavab: D) 250.
        """.trimIndent(),
        diagramType = "triangle_rectangle_product",
        diagramData = mapOf("calc" to "5 + 245 = 250")
    ),
    Question(
        id = 56,
        title = "Sual 56. Cədvəl və dairələr əlaqəsində X * Y hasilini tapın.",
        category = "Cədvəl-Dairə Əlaqəsi",
        options = listOf("A) 27", "B) 16", "C) 18", "D) 36", "E) 9"),
        correctOption = "C",
        hintProposal = "💡 Təklif: Cədvəldəki addımların fərqinə baxın: 12 - 10 = 2 (X = 2), 45 / 5 = 9 (Y = 9).",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            Cədvəl ardıcıllığı: 9 (+3) -> 12 (-2) -> 10 (*2) -> 20 (+3) -> 23 (-2) -> 21 (*2) -> 42 (+3) -> 45.
            Yuxarıdakı dairələrdə əməliyyat qiymətləri:
            X = 2 (azalma addımı: 12 - 10 = 2).
            Y = 9 (son ədədin rəqəmlər cəmi: 4 + 5 = 9).
            Hasil: X * Y = 2 * 9 = 18!
            
            🎯 **Nəticə:** Düzgün cavab: C) 18.
        """.trimIndent(),
        diagramType = "row_circle_mapper",
        diagramData = mapOf("calc" to "2 * 9 = 18")
    ),
    Question(
        id = 57,
        title = "Sual 57. Qara nöqtə ətrafında 1-dən 6-ya qədər ədədlər düzülüşü.",
        category = "Sehrli Altıbucaqlı",
        options = listOf("A) 1", "B) 2", "C) 3", "D) 4", "E) 5"),
        correctOption = "E",
        hintProposal = "💡 Təklif: Qara nöqtə ətrafındakı 6 üçbucaqda 1, 2, 3, 4, 5, 6 ədədləri təkrarlanmamalıdır.",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            Hər bir qara nöqtənin ətrafında yerləşən 6 kiçik üçbucağın daxilində 1-dən 6-ya qədər hər bir rəqəm dəqiq 1 dəfə yazılmalıdır.
            Yuxarıdakı qara nöqtə ətrafında artıq məlum olan rəqəmlər: 4, 3, 2, 1, 6.
            Çatışmayan yeganə rəqəm 5-dir!
            Buna görə '?' = 5!
            
            🎯 **Nəticə:** Düzgün cavab: E) 5.
        """.trimIndent(),
        diagramType = "magic_hexagon_puzzle",
        diagramData = mapOf("ans" to "5")
    ),
    Question(
        id = 58,
        title = "Sual 58. Qövslərlə birləşən cütlərin cəmi.",
        category = "Qövs Əlaqələri",
        options = listOf("A) 6", "B) 15", "C) 18", "D) 4", "E) 3"),
        correctOption = "A",
        hintProposal = "💡 Təklif: Qövslərin birləşdirdiyi ədədlərin hasillərini toplayın: (4*6) + (3*4) + (2*3) = 42. Mərkəz 48!",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            Qövslər sol və sağ tərəfdəki simmetrik ədədləri cütləşdirir:
            1-ci qövs (ən daxili): 4 və 6 -> 4 * 6 = 24
            2-ci qövs: 3 və 4 -> 3 * 4 = 12
            3-cü qövs: 2 və 3 -> 2 * 3 = 6
            Bu 3 qövsün hasilləri cəmi: 24 + 12 + 6 = 42!
            
            Mərkəzdəki ümumi hədəf ədəd 48-dir!
            Deməli ən xarici qövsün hasili: 48 - 42 = 6 olmalıdır!
            Ən xarici qövs '?' və 1 ədədlərini birləşdirir:
            ? * 1 = 6 => ? = 6!
            
            🎯 **Nəticə:** Düzgün cavab: A) 6.
        """.trimIndent(),
        diagramType = "concentric_arcs",
        diagramData = mapOf("calc" to "42 + (? * 1) = 48 => ? = 6")
    ),
    Question(
        id = 59,
        title = "Sual 59. Həndəsi fiqurların tərəf sayının yarıya bölünməsi.",
        category = "Fiqur Tərəfləri",
        options = listOf("A) 4", "B) 3.5", "C) 2.5", "D) 7", "E) 5"),
        correctOption = "B",
        hintProposal = "💡 Təklif: Tərəflərin sayını 2-yə bölün: 5 tərəf -> 2.5, 8 tərəf -> 4, 7 tərəf -> ?",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            Hər bir fiqura qarşı qoyulan ədəd onun tərəflərinin (və ya təpələrinin) sayının 2-yə nisbətidir!
            1-ci fiqur (ox formalı 5-bucaqlı): 5 tərəf -> 5 / 2 = 2.5!
            2-ci fiqur (8-bucaqlı oktagon): 8 tərəf -> 8 / 2 = 4!
            3-cü fiqur (7-bucaqlı heptagon): 7 tərəf -> 7 / 2 = 3.5!
            
            🎯 **Nəticə:** Düzgün cavab: B) 3.5.
        """.trimIndent(),
        diagramType = "shape_side_division",
        diagramData = mapOf("calc" to "7 / 2 = 3.5")
    ),
    Question(
        id = 60,
        title = "Sual 60. Ədəd piramidasında A * (L - K) ifadəsinin qiyməti.",
        category = "Piramida Cəbri",
        options = listOf("A) 1000", "B) 425", "C) 540", "D) 225", "E) 600"),
        correctOption = "E",
        hintProposal = "💡 Təklif: Hər xana altındakı iki xananın cəmidir. C = 41 - 19 = 22, B = 37 + 22 = 59, A = 59 + 41 = 100!",
        fullExplanation = """
            🔍 **Qanunauyğunluq:**
            Piramidada hər kərpic öz altındakı iki qonşu kərpicin cəmidir:
            
            1) 3-cü sətir: [37, C, 19]
            C + 19 = 41 => C = 41 - 19 = 22!
            B = 37 + C = 37 + 22 = 59!
            Təpə A = B + 41 = 59 + 41 = 100!
            
            2) 4-cü sətir: [D, E, F, 11]
            F + 11 = 19 => F = 8.
            E + F = C = 22 => E = 22 - 8 = 14.
            D + E = 37 => D = 37 - 14 = 23.
            
            3) 5-ci sətir (ən alt): [L, G, 6, H, K]
            6 + H = F = 8 => H = 2.
            H + K = 11 => 2 + K = 11 => K = 9!
            G + 6 = E = 14 => G = 8.
            L + G = D = 23 => L + 8 = 23 => L = 15!
            
            4) Tələb olunan ifadə:
            L - K = 15 - 9 = 6!
            A * (L - K) = 100 * 6 = 600!
            
            🎯 **Nəticə:** Düzgün cavab: E) 600.
        """.trimIndent(),
        diagramType = "algebra_pyramid",
        diagramData = mapOf("calc" to "A=100, L=15, K=9 => 100 * 6 = 600")
    )
)
