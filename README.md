# Java CV Generator

## 1. Proje Hakkında

Java CV Generator, Java programlama dili kullanılarak geliştirilen ve kişisel bilgiler ile iş deneyimlerini PDF formatında bir özgeçmişe dönüştüren bir uygulamadır.

Bu proje, üniversite kapsamında verilen dönem sonu değerlendirme ödevi için hazırlanmıştır. Projenin temel amacı, Nesne Yönelimli Programlama (Object-Oriented Programming - OOP) prensiplerini uygulamak ve OpenPDF kütüphanesini kullanarak PDF formatında bir özgeçmiş oluşturmaktır.

Uygulamada kişisel bilgiler, iş deneyimleri ve PDF oluşturma işlemleri farklı sınıflara ayrılmıştır. Böylece her sınıfın belirli bir sorumluluğu bulunur ve kodun okunabilirliği artırılır.

## 2. Projenin Özellikleri

* Kişisel bilgilerle PDF formatında özgeçmiş oluşturma.
* Ad soyad, e-posta ve telefon bilgilerini gösterme.
* Profil fotoğrafını PDF belgesine ekleme.
* Üç adet örnek iş deneyimini özgeçmişte listeleme.
* A4 boyutunda PDF belgesi oluşturma.
* Nesne Yönelimli Programlama prensiplerinden yararlanma.
* PDF oluşturma işlemini ayrı bir sınıfta gerçekleştirme.

## 3. Kullanılan Teknolojiler

* **Programlama Dili:** Java 21
* **Bağımlılık Yönetimi:** Apache Maven
* **PDF Kütüphanesi:** OpenPDF 1.3.30
* **Geliştirme Ortamı:** IntelliJ IDEA
* **Sürüm Kontrolü:** Git ve GitHub

## 4. Proje Yapısı

```text
java-cv-generator/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── cvgenerator/
│                   ├── Main.java
│                   ├── Person.java
│                   ├── WorkExperience.java
│                   └── CVGeneration.java
├── images/
│   └── profile.jpg
├── pom.xml
├── Sara_Yasser_CV.pdf
└── README.md
```

## 5. Sınıfların Açıklaması

### 5.1. Main.java

`Main` sınıfı, uygulamanın başlangıç noktasıdır. `main()` metodu içerisinde kişisel bilgiler tanımlanır ve bir `Person` nesnesi oluşturulur.

Daha sonra üç adet `WorkExperience` nesnesi oluşturularak `addWorkExperience()` metodu aracılığıyla kişiye eklenir.

Son olarak `CVGeneration.createPDF()` metodu çağrılarak PDF oluşturma işlemi başlatılır.

Bu sınıf, uygulamanın çalışma sırasını yönetir.

### 5.2. Person.java

`Person` sınıfı, özgeçmiş sahibinin kişisel bilgilerini ve iş deneyimlerini temsil eder.

Sınıfta bulunan temel alanlar şunlardır:

* `fullName`: Ad ve soyad.
* `email`: E-posta adresi.
* `phone`: Telefon numarası.
* `imagePath`: Profil fotoğrafının dosya yolu.
* `experiences`: İş deneyimlerini saklayan liste.

Constructor, kişisel bilgileri başlatır ve `ArrayList` türünde boş bir iş deneyimi listesi oluşturur.

`addWorkExperience()` metodu, yeni iş deneyimlerini listeye eklemek için kullanılır.

### 5.3. WorkExperience.java

`WorkExperience` sınıfı, bir iş veya staj deneyimini temsil eder.

Her nesne aşağıdaki bilgileri içerir:

* `companyName`: Şirket adı.
* `jobTitle`: İş pozisyonu.
* `duration`: Çalışma süresi.
* `description`: İşin veya stajın açıklaması.

Constructor, yeni bir iş deneyimi oluşturulurken bu dört özelliğin başlangıç değerlerini atar. Getter ve setter metotları, alanlara erişmek ve gerektiğinde değerlerini değiştirmek için kullanılır.

Bu sınıf sayesinde her iş deneyimi ayrı bir nesne olarak temsil edilir.

### 5.4. CVGeneration.java

`CVGeneration` sınıfı, PDF belgesinin oluşturulmasından sorumludur.

`createPDF(Person person, String outputPath)` metodu aşağıdaki işlemleri gerçekleştirir:

1. A4 boyutunda bir `Document` nesnesi oluşturur.
2. `PdfWriter` aracılığıyla PDF dosyasının yazılmasını sağlar.
3. Başlık ve metinler için yazı tiplerini tanımlar.
4. Kişisel bilgiler ile profil fotoğrafını bir tabloda düzenler.
5. İş deneyimlerini PDF belgesine ekler.
6. Belgeyi kapatarak PDF oluşturma işlemini tamamlar.

Bu işlemlerin ayrı bir sınıfta yapılması, `Main` sınıfının PDF oluşturma ayrıntılarından bağımsız kalmasını sağlar.

## 6. Kullanılan Nesneler ve Amaçları

| Nesne veya yapı    | Kullanım amacı                                              |
| ------------------ | ----------------------------------------------------------- |
| `Person`           | Özgeçmiş sahibinin bilgilerini ve iş deneyimlerini tutar.   |
| `WorkExperience`   | Bir iş deneyiminin bilgilerini temsil eder.                 |
| `ArrayList`        | İş deneyimlerini saklar.                                    |
| `Document`         | PDF belgesinin içeriğini ve sayfa yapısını yönetir.         |
| `PdfWriter`        | PDF içeriğinin dosyaya yazılmasını sağlar.                  |
| `PdfPTable`        | Kişisel bilgiler ile fotoğrafı tablo düzeninde yerleştirir. |
| `PdfPCell`         | Tablo hücrelerini oluşturur.                                |
| `Paragraph`        | PDF belgesine metin ekler.                                  |
| `Font`             | Metinlerin yazı tipi ve boyutunu belirler.                  |
| `Image`            | Profil fotoğrafını PDF belgesine ekler.                     |
| `File`             | Fotoğraf dosyasının mevcut olup olmadığını kontrol eder.    |
| `FileOutputStream` | PDF dosyasına veri yazılmasını sağlar.                      |

`Document`, `PdfWriter`, `PdfPTable`, `PdfPCell`, `Paragraph`, `Font` ve `Image` gibi sınıflar OpenPDF kütüphanesinden gelir. `Person` ve `WorkExperience` ise proje kapsamında oluşturulan sınıflardır.

## 7. Nesne Yönelimli Programlama Prensipleri

### 7.1. Sınıf ve Nesne

Sınıflar, nesnelerin özelliklerini ve davranışlarını tanımlar. Projede `Person` ve `WorkExperience` sınıfları kullanılarak kişisel bilgiler ve iş deneyimleri modellenmiştir.

### 7.2. Kapsülleme (Encapsulation)

`Person` ve `WorkExperience` sınıflarındaki veri alanları `private` olarak tanımlanmıştır. Böylece bu alanlara sınıf dışından doğrudan erişim sınırlandırılır.

Getter ve setter metotları, bu verilere erişmek ve gerektiğinde değerlerini değiştirmek için kullanılır.

### 7.3. Constructor

Constructor, yeni bir nesne oluşturulurken başlangıç değerlerini atar.

`Person` sınıfının constructor metodu kişisel bilgileri ve boş bir iş deneyimi listesini başlatır. `WorkExperience` constructor metodu ise bir iş deneyiminin dört temel özelliğini başlatır.

### 7.4. Koleksiyon Kullanımı

`List<WorkExperience>` ve `ArrayList` kullanılarak bir kişiye ait birden fazla iş deneyimi saklanır.

### 7.5. Sorumlulukların Ayrılması

Her sınıf belirli bir görevi yerine getirir. `Main` uygulamanın akışını yönetirken `Person` kişisel bilgileri, `WorkExperience` iş deneyimlerini, `CVGeneration` ise PDF oluşturma işlemini yönetir.

## 8. Erişim Belirleyiciler

Projede kullanılan erişim belirleyiciler şunlardır:

* `private`: Sınıf alanlarının sınıf dışından doğrudan erişilmesini sınırlandırır.
* `public`: Metotların ve constructor'ların diğer sınıflardan erişilebilir olmasını sağlar.
* `static`: `CVGeneration.createPDF()` metodunun bir `CVGeneration` nesnesi oluşturmadan sınıf adı üzerinden çağrılmasını sağlar.

Java'da ayrıca `protected` ve erişim belirleyicisi belirtilmediğinde kullanılan varsayılan erişim düzeyi de bulunur. Ancak bunlar projedeki sınıf alanlarının temel erişim yaklaşımını oluşturmaz.

## 9. Kurulum ve Çalıştırma

### Gereksinimler

* JDK 21
* Apache Maven
* IntelliJ IDEA veya başka bir Java geliştirme ortamı

### Adımlar

**1. GitHub deposunu klonlayın:**

```bash
git clone <repository-url>
```

`<repository-url>` yerine gerçek GitHub depo adresinizi yazın.

**2. Proje dizinine girin:**

```bash
cd java-cv-generator
```

**3. Projeyi derleyin:**

```bash
mvn clean package
```

**4. Uygulamayı çalıştırın:**

IntelliJ IDEA üzerinden `Main.java` dosyasını açıp `main()` metodunu çalıştırın.

Program, `Sara_Yasser_CV.pdf` adlı PDF dosyasını belirtilen çıktı yolunda oluşturur.

## 10. Örnek Çıktı

Uygulama başarıyla çalıştığında PDF dosyasında aşağıdaki bilgiler bulunur:

* Ad soyad ve iletişim bilgileri.
* Profil fotoğrafı.
* Üç örnek iş deneyimi.
* Şirket adları, pozisyonlar, çalışma süreleri ve görev açıklamaları.

Profil fotoğrafının görüntülenmesi için `images/profile.jpg` dosyasının doğru konumda bulunması gerekir. Dosya bulunamazsa uygulama fotoğraf yerine `[Profile Image]` metnini gösterir.

## 11. Yapay Zekâ Araçlarının Kullanımı
Bu projeyi yaparken yapay zekâ araçlarından yardım aldım. Bu araçları kod yazma, kodu anlama ve karşılaştığım hataları çözme konusunda kullandım. Projeyi kendim inceleyerek çalışmasını kontrol ettim.


Bu bölüm, proje sürecinde gerçekten gerçekleştirilen çalışmalara göre düzenlenmelidir.

## 12. Geliştirici

**Sara Yasser**
Software Engineering Student
Kırklareli University

---

Bu proje, Java programlama dili ve Nesne Yönelimli Programlama konularındaki bilgi ve becerileri geliştirmek amacıyla hazırlanmış bir üniversite ödevidir.
