package com.smartpick.repository

import com.smartpick.R // untuk akses gambar dari drawable
import com.smartpick.model.Phone // pastikan ini ada di model/Phone.kt

val dummyPhones: List<Phone> = listOf(
    Phone(
        imageResId = R.drawable.hp_samsung,
        merek = "Galaxy S23",
        brand = "Samsung",
        harga = "Rp 12.000.000",
        rating = 4,
        deskripsi = "Samsung Galaxy S23 adalah smartphone flagship yang dirancang untuk performa maksimal, dengan desain premium, kamera berkualitas profesional, serta daya tahan baterai yang mumpuni.",
        spesifikasi = """
        • Prosesor: Qualcomm Snapdragon 8 Gen 2
        • RAM: 8GB LPDDR5
        • Penyimpanan: 256GB UFS 4.0
        • Layar: 6.1” Dynamic AMOLED 2X, FHD+, 120Hz
        • Kamera Belakang: Triple 50MP (wide) + 12MP (ultrawide) + 10MP (telephoto)
        • Kamera Depan: 12MP
        • Baterai: 3900mAh, Fast Charging 25W
        • OS: Android 13, One UI 5.1
        • Fitur Lain: IP68, Wireless Charging, Gorilla Glass Victus 2
    """.trimIndent(),
        kebutuhan = listOf("Gaming", "Fotografi", "Multitasking"),
        tersedia = true
    )
    ,
    Phone(
        imageResId = R.drawable.hp_redmi_note,
        merek = "Redmi Note 12 Pro",
        brand = "Xiaomi",
        harga = "Rp 3.500.000",
        rating = 4,
        deskripsi = "Redmi Note 12 Pro menghadirkan kombinasi fitur premium dan harga terjangkau. Ideal untuk pengguna yang mencari performa andal, kamera mumpuni, dan layar berkualitas tinggi dalam satu paket.",
        spesifikasi = """
        • Prosesor: MediaTek Dimensity 1080 (6nm)
        • RAM: 6GB LPDDR4X
        • Penyimpanan: 128GB UFS 2.2
        • Layar: 6.67” AMOLED, FHD+, 120Hz
        • Kamera Belakang: 50MP (Sony IMX766, OIS) + 8MP (ultrawide) + 2MP (macro)
        • Kamera Depan: 16MP
        • Baterai: 5000mAh, Fast Charging 67W
        • OS: Android 12, MIUI 13 (upgradeable)
        • Fitur Lain: Dual Stereo Speaker, IR Blaster, 5G
    """.trimIndent(),
        kebutuhan = listOf("Gaming", "Fotografi"),
        tersedia = false
    )
    ,
    Phone(
        imageResId = R.drawable.hp_oppo_reno,
        merek = "OPPO Reno10 5G",
        brand = "OPPO",
        harga = "Rp 5.999.000",
        rating = 4,
        deskripsi = "OPPO Reno10 5G hadir dengan desain stylish dan performa menawan. Kamera potret profesional dan pengisian daya super cepat menjadikannya pilihan menarik di kelas menengah.",
        spesifikasi = """
        • Prosesor: MediaTek Dimensity 7050
        • RAM: 8GB LPDDR4X
        • Penyimpanan: 256GB UFS 2.2
        • Layar: 6.7” AMOLED, FHD+, 120Hz
        • Kamera Belakang: 64MP (wide) + 32MP (telephoto) + 8MP (ultrawide)
        • Kamera Depan: 32MP
        • Baterai: 5000mAh, SuperVOOC 67W
        • OS: Android 13, ColorOS 13
        • Fitur Lain: NFC, 5G, Stereo Speaker
    """.trimIndent(),
        kebutuhan = listOf("Fotografi", "Multitasking", "Media Sosial"),
        tersedia = true
    )
    ,
    Phone(
        imageResId = R.drawable.hp_realme_narzo,
        merek = "Realme Narzo 60x",
        brand = "Realme",
        harga = "Rp 2.399.000",
        rating = 3,
        deskripsi = "Realme Narzo 60x adalah ponsel entry-level dengan desain kekinian, mendukung jaringan 5G, cocok untuk pengguna muda yang membutuhkan performa harian.",
        spesifikasi = """
        • Prosesor: MediaTek Dimensity 6100+
        • RAM: 6GB
        • Penyimpanan: 128GB
        • Layar: 6.72” IPS LCD, FHD+, 120Hz
        • Kamera Belakang: 64MP (wide) + 2MP (depth)
        • Kamera Depan: 8MP
        • Baterai: 5000mAh, Fast Charging 33W
        • OS: Android 13, Realme UI 4.0
        • Fitur Lain: Side Fingerprint, 5G
    """.trimIndent(),
        kebutuhan = listOf("Harian", "Streaming", "Media Sosial"),
        tersedia = true
    )
    ,
    Phone(
        imageResId = R.drawable.hp_vivo_v,
        merek = "Vivo V29 5G",
        brand = "Vivo",
        harga = "Rp 6.499.000",
        rating = 5,
        deskripsi = "Vivo V29 5G menawarkan kamera portrait profesional dan layar AMOLED melengkung yang tajam, cocok untuk pengguna yang suka fotografi dan tampilan elegan.",
        spesifikasi = """
        • Prosesor: Qualcomm Snapdragon 778G
        • RAM: 8GB
        • Penyimpanan: 256GB
        • Layar: 6.78” AMOLED, FHD+, 120Hz (Curved)
        • Kamera Belakang: 50MP OIS + 8MP ultrawide + 2MP depth
        • Kamera Depan: 50MP AF
        • Baterai: 4600mAh, FlashCharge 80W
        • OS: Android 13, Funtouch OS 13
        • Fitur Lain: Aura Light Portrait, IP68, 5G
    """.trimIndent(),
        kebutuhan = listOf("Fotografi", "Konten Kreator", "Multitasking"),
        tersedia = true
    )
    ,
    Phone(
        imageResId = R.drawable.hp_infinix_zero,
        merek = "Infinix Zero 5G 2023",
        brand = "Infinix",
        harga = "Rp 2.899.000",
        rating = 4,
        deskripsi = "Infinix Zero 5G 2023 membawa performa tinggi dengan harga terjangkau. Cocok untuk gaming dan multitasking berkat chipset kencang dan RAM besar.",
        spesifikasi = """
        • Prosesor: MediaTek Dimensity 920
        • RAM: 8GB (+ RAM virtual)
        • Penyimpanan: 128GB
        • Layar: 6.78” IPS LCD, FHD+, 120Hz
        • Kamera Belakang: 50MP + 2MP + 2MP
        • Kamera Depan: 16MP
        • Baterai: 5000mAh, Fast Charging 33W
        • OS: Android 12, XOS 12
        • Fitur Lain: Expandable Storage, Dual Speaker
    """.trimIndent(),
        kebutuhan = listOf("Gaming", "Pelajar", "Multitasking"),
        tersedia = true
    )
    ,
    Phone(
        imageResId = R.drawable.hp_poco_x,
        merek = "POCO X5 Pro 5G",
        brand = "POCO",
        harga = "Rp 4.399.000",
        rating = 4,
        deskripsi = "POCO X5 Pro 5G cocok untuk para gamers dan content creator. Ditenagai prosesor kencang, layar AMOLED, dan kamera utama 108MP, performanya sangat solid di kelas menengah.",
        spesifikasi = """
        • Prosesor: Qualcomm Snapdragon 778G
        • RAM: 8GB
        • Penyimpanan: 256GB
        • Layar: 6.67” AMOLED, FHD+, 120Hz
        • Kamera Belakang: 108MP + 8MP ultrawide + 2MP macro
        • Kamera Depan: 16MP
        • Baterai: 5000mAh, Turbo Charge 67W
        • OS: Android 13, MIUI 14 for POCO
        • Fitur Lain: IR Blaster, NFC, Stereo Speaker
    """.trimIndent(),
        kebutuhan = listOf("Gaming", "Fotografi", "Video Editing"),
        tersedia = true
    )
    ,
    Phone(
        imageResId = R.drawable.hp_galaxy_a,
        merek = "Galaxy A54 5G",
        brand = "Samsung",
        harga = "Rp 5.999.000",
        rating = 4,
        deskripsi = "Samsung Galaxy A54 5G menghadirkan kualitas kamera dan layar premium di kelas menengah. Cocok untuk multitasking dan aktivitas harian yang intensif.",
        spesifikasi = """
        • Prosesor: Exynos 1380 (5nm)
        • RAM: 8GB
        • Penyimpanan: 256GB
        • Layar: 6.4” Super AMOLED, FHD+, 120Hz
        • Kamera Belakang: 50MP OIS + 12MP ultrawide + 5MP macro
        • Kamera Depan: 32MP
        • Baterai: 5000mAh, Fast Charging 25W
        • OS: Android 13, One UI 5.1
        • Fitur Lain: IP67, NFC, Gorilla Glass 5
    """.trimIndent(),
        kebutuhan = listOf("Multitasking", "Fotografi", "Media Sosial"),
        tersedia = true
    ),
    Phone(
        imageResId = R.drawable.hp_rog_phone,
        merek = "ROG Phone 6",
        brand = "Asus",
        harga = "Rp 10.999.000",
        rating = 5,
        deskripsi = "ROG Phone 6 adalah ponsel gaming sejati dengan performa ekstrem dan fitur-fitur pendukung seperti pendingin aktif dan mode gaming khusus.",
        spesifikasi = """
        • Prosesor: Snapdragon 8+ Gen 1
        • RAM: 12GB LPDDR5
        • Penyimpanan: 256GB UFS 3.1
        • Layar: 6.78” AMOLED, FHD+, 165Hz, HDR10+
        • Kamera Belakang: 50MP + 13MP ultrawide + 5MP macro
        • Kamera Depan: 12MP
        • Baterai: 6000mAh, HyperCharge 65W
        • OS: Android 12, ROG UI
        • Fitur Lain: AirTrigger, Dual USB-C, Stereo Speaker
    """.trimIndent(),
        kebutuhan = listOf("Gaming", "Streaming", "Performa Tinggi"),
        tersedia = true
    ),
    Phone(
        imageResId = R.drawable.hp_iphone,
        merek = "iPhone 14",
        brand = "Apple",
        harga = "Rp 14.999.000",
        rating = 5,
        deskripsi = "iPhone 14 menghadirkan pengalaman iOS terbaik dengan kamera canggih dan performa luar biasa, ideal untuk produktivitas dan gaya hidup digital.",
        spesifikasi = """
        • Prosesor: Apple A15 Bionic (5-core GPU)
        • RAM: 6GB
        • Penyimpanan: 128GB
        • Layar: 6.1” Super Retina XDR OLED
        • Kamera Belakang: 12MP wide + 12MP ultrawide
        • Kamera Depan: 12MP TrueDepth
        • Baterai: ±3279mAh, Fast Charging 20W
        • OS: iOS 16 (upgradable)
        • Fitur Lain: Face ID, MagSafe, Dolby Vision
    """.trimIndent(),
        kebutuhan = listOf("Fotografi", "Produktivitas", "Video Editing"),
        tersedia = true
    )



)
