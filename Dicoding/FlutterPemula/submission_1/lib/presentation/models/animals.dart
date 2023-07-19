

import 'package:submission_1/presentation/enums.dart';

import 'Animal.dart';

List<Animal> animals = [
  Animal(
      name: "Anjing",
      description:"Anjing adalah hewan peliharaan yang sangat populer di seluruh dunia karena sifatnya yang setia dan cerdas. Anjing berasal dari keluarga Canidae dan telah lama menjadi sahabat manusia dalam berbagai aktivitas seperti berburu, menjaga keamanan, dan sebagai hewan peliharaan. Anjing memiliki sifat yang setia dan selalu siap membantu pemiliknya dalam berbagai situasi. Mereka juga mudah dilatih dan sangat cerdas, sehingga sering digunakan sebagai hewan pengawal, penyelamat, dan hewan terapi. Anjing dapat hidup hingga 15 tahun dan membutuhkan perawatan yang baik untuk kesehatan mereka.",
      type: AnimType.karnivora,
      imageAssetPath: "images/anjing.jpg",
      imageAssetsUrl: [
        "images/anjing_dlc/anjing_dlc_2.jpg",
        "images/anjing_dlc/anjing_dlc_3.jpg",
        "images/anjing_dlc/anjing_dlc_4.jpg",

      ], family: Family.Canidae, lifeSpan: 13),

  Animal(
      name: "Dino - Trex",
      description: "Dinosaurus adalah hewan prasejarah yang telah punah dan diperkirakan hidup sekitar 230 juta tahun yang lalu hingga 65 juta tahun yang lalu. Dinosaurus memiliki berbagai macam ukuran dan bentuk tubuh, dari yang sangat kecil seperti burung hingga yang sangat besar seperti Tyrannosaurus Rex. Dinosaurus diperkirakan telah punah karena bencana alam atau perubahan lingkungan yang drastis. Namun, fosil-fosil dinosaurus yang ditemukan di seluruh dunia memberikan informasi yang berharga tentang kehidupan di masa lalu dan menjadi objek studi bagi para ilmuwan hingga saat ini.",
      type: AnimType.karnivora,
      imageAssetPath: "images/dino.jpg",
      imageAssetsUrl: [
        "images/dino_dlc/dino_dlc_1.jpg",
        "images/dino_dlc/dino_dlc_2.jpg",
        "images/dino_dlc/dino_dlc_3.png",
      ],
      family: Family.Tyrannosauridae,
      lifeSpan: -99),

  Animal(
      name: "Ikan ",
      description: "Ikan adalah hewan air yang hidup di perairan laut dan tawar di seluruh dunia. Ikan memiliki berbagai macam ukuran dan bentuk tubuh, dari yang sangat kecil hingga yang sangat besar, serta memiliki berbagai warna dan pola yang indah. Ikan adalah hewan pemakan daging atau tumbuhan, tergantung pada jenisnya. Ikan juga memiliki peran yang penting dalam ekosistem laut dan seringkali digunakan sebagai bahan makanan manusia di seluruh dunia.",
      type: AnimType.herbivora,
      imageAssetPath: "images/ikan.jpg",
      imageAssetsUrl: [
        "images/ikan_dlc/ikan_dlc_1.jpg",
        "images/ikan_dlc/ikan_dlc_2.jpg",
        "images/ikan_dlc/ikan_dlc_3.jpg",
      ],
      family: Family.Salmonidae,
      lifeSpan: -1),

  Animal(
      name: "Kuda",
      description: "Kudu adalah hewan mamalia besar dari keluarga Bovidae yang biasa ditemukan di Afrika. Kudu memiliki ciri khas seperti tanduk panjang yang melengkung ke belakang dan tubuh berwarna coklat kemerahan dengan garis putih di tubuhnya. Kudu adalah hewan pemakan tumbuhan dan sering ditemukan di daerah savana dan hutan. Mereka memiliki kemampuan melompat yang luar biasa dan seringkali digunakan sebagai simbol kekuatan dan keindahan di Afrika.",
      type: AnimType.herbivora,
      imageAssetPath: "images/kuda.jpg",
      imageAssetsUrl: [
        "images/kuda_dlc/horse_dlc_1.jpg",
        "images/kuda_dlc/horse_dlc_2.jpg",
        "images/kuda_dlc/horse_dlc_3.jpg",
      ],
      family: Family.Equidae,
      lifeSpan: 30),

  Animal(
      name: "Kucing",
      description: "Kucing adalah mamalia kecil dari keluarga Felidae yang memiliki ciri khas yaitu bulu halus dan lentur serta kuku yang tajam. Kucing telah menjadi hewan peliharaan populer di seluruh dunia karena sifatnya yang lucu, lembut, dan mandiri. Kucing juga memiliki kemampuan berburu yang luar biasa dan seringkali digunakan sebagai predator alami untuk mengendalikan populasi hewan pengerat. Kucing juga memiliki sifat yang mandiri dan kadang-kadang sulit dilatih, tetapi mereka sangat senang bermain dan berinteraksi dengan manusia. Kucing dapat hidup hingga 20 tahun dan membutuhkan perawatan yang baik untuk kesehatan mereka.",
      type: AnimType.herbivora,
      imageAssetPath: "images/kucing.jpg",
      imageAssetsUrl: [
        "images/kucing_dlc/kucing_dlc_1.jpg",
        "images/kucing_dlc/kucing_dlc_2.jpg",
        "images/kucing_dlc/kucing_dlc_3.jpg",
      ],
      family: Family.Equidae,
      lifeSpan: 30),

  Animal(
      name: "Lebah",
      description: "Lebah adalah serangga yang sangat penting dalam ekosistem karena berperan dalam penyerbukan tanaman. Lebah adalah serangga sosial yang hidup dalam koloni dan memiliki sistem komunikasi yang kompleks. Mereka menghasilkan madu, yang merupakan sumber makanan manusia yang sangat penting. Lebah juga memiliki sifat yang agresif ketika merasa terancam dan dapat menyebabkan gigitan yang menyakitkan.",
      type: AnimType.herbivora,
      imageAssetPath: "images/lebah.jpg",
      imageAssetsUrl: [
        "images/lebah_dlc/lebah_dlc_1.jpg",
        "images/lebah_dlc/lebah_dlc_2.jpg",
        "images/lebah_dlc/lebah_dlc_3.jpg",
      ],
      family: Family.Apidae,
      lifeSpan: -1),
  Animal(
      name: "Macan",
      description: "Macan adalah hewan mamalia besar dari keluarga Felidae yang ditemukan di Asia dan Afrika. Macan memiliki ciri khas seperti bulu berwarna kekuningan atau coklat dengan bercak-bercak hitam, serta kuku yang tajam dan kuat. Macan adalah hewan predator yang sangat kuat dan lincah, serta memiliki kemampuan untuk memanjat pohon dan berenang di air. Macan juga seringkali digunakan sebagai simbol kekuatan dan keindahan di banyak budaya di seluruh dunia.",
      type: AnimType.karnivora,
      imageAssetPath: "images/macan.jpg",
      imageAssetsUrl: [
        "images/macan_dlc/macan_dlc_1.jpg",
        "images/macan_dlc/macan_dlc_2.jpg",
        "images/macan_dlc/macan_dlc_3.jpg",
      ],
      family: Family.Felidae,
      lifeSpan: 30),
  Animal(
      name: "Nyamuk",
      description: "Nyamuk adalah serangga kecil yang terkenal dengan gigitannya yang menyebabkan gatal dan dapat membawa penyakit seperti malaria dan demam berdarah. Nyamuk jantan memakan nektar bunga sementara nyamuk betina membutuhkan darah untuk berkembang biak.",
      type: AnimType.karnivora,
      imageAssetPath: "images/nyamuk.jpg",
      imageAssetsUrl: [
        "images/nyamuk_dlc/nyamuk_dlc_1.jpg",
        "images/nyamuk_dlc/nyamuk_dlc_2.jpg",
        "images/nyamuk_dlc/nyamuk_dlc_3.jpg",
      ],
      family: Family.Culicidae,
      lifeSpan: -1),

  Animal(
      name: "Thanos",
      description: "Thanos adalah karakter fiksi dalam dunia komik dan film dari Marvel Cinematic Universe. Thanos diperkenalkan sebagai antagonis dalam film Avengers: Infinity War dan Avengers: Endgame. Thanos adalah makhluk alien yang memiliki kekuatan yang sangat kuat dan memiliki tujuan untuk menghancurkan separuh populasi seluruh galaksi untuk mengurangi kelebihan populasi yang mengancam kelangsungan hidup. Karakter Thanos juga menimbulkan berbagai macam interpretasi dan diskusi tentang filosofi dan etika di kalangan penggemar film dan komik.",
      type: AnimType.omnivora,
      imageAssetPath: "images/thanos.jpg",
      imageAssetsUrl: [
        "images/kucing_dlc/kucing_dlc_1.jpg",
        "images/kucing_dlc/kucing_dlc_2.jpg",
        "images/kucing_dlc/kucing_dlc_3.jpg",
      ],
      lifeSpan: 100,
      family: Family.Mammal),

  Animal(
      name: "Tupai",
      description:"Tupai adalah hewan mamalia kecil dari keluarga Sciuridae yang ditemukan di seluruh dunia, kecuali di Australia dan Antartika. Tupai memiliki ciri khas seperti ekor yang panjang dan lebat, serta bulu yang lembut dan halus. Tupai merupakan hewan yang aktif dan seringkali ditemukan di pepohonan di hutan atau daerah pedesaan. Mereka juga memiliki kemampuan untuk memanjat dan melompat dengan sangat lincah. Tupai adalah hewan omnivora dan memakan berbagai macam makanan seperti buah-buahan, biji-bijian, serangga, dan bahkan burung kecil atau tikus." ,
      type: AnimType.herbivora,
      imageAssetPath: "images/tupai.jpg",
      imageAssetsUrl: [
        "images/tupai_dlc/tupai_dlc_1.jpg",
        "images/tupai_dlc/tupai_dlc_2.jpg",
        "images/tupai_dlc/tupai_dlc_3.jpg",
      ],
      family: Family.Sciuridae ,
      lifeSpan: 10),

];