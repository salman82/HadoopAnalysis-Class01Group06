# Hadoop vs Java Wordcount Efficiency Analysis
## **Authors**
- Brian Yudha Sandi - 2106637082
- Muhammad Irfan Fakhrianto
- Muhammad Rizky Utomo - 2106731320
- Muhamad Salman Sadad - 2106731371

## **Hadoop Introduction**

<p align="justify">Hadoop adalah framework open source hasil pengembangan Apache Software Foundation yang didesain untuk menyimpan, mengelola, dan menganalisis data yang sangat besar (big data) secara terdistribusi. Cara kerja Hadoop dalam menangani volume data yang sangat besar dengan memecahnya menjadi blok-blok yang lebih kecil dan mendistribusikannya di sejumlah komputer atau server yang terhubung dalam sebuah cluster untuk diolah secara paralel.</p>

Arsitektur Hadoop terdiri dari 4 modul utama: 
### 1) Hadoop Distributed File System (HDFS)
<p align="justify">HDFS adalah sistem file terdistribusi yang dirancang khusus untuk menyimpan dan mengelola data dalam skala besar. Data yang diunggah ke HDFS dibagi menjadi blok-blok kecil dan didistribusikan di sejumlah node dalam cluster Hadoop. Ini memungkinkan data untuk disimpan dengan aman dan berdistribusi di beberapa node, sehingga memberikan ketahanan dan ketersediaan yang tinggi.</p>

### 2) Apache MapReduce
<p align="justify">Apache MapReduce adalah model pemrograman yang digunakan untuk memproses data yang terdistribusi di dalam cluster Hadoop secara paralel. MapReduce melakukan pemrosesan paralel dengan membagi tugas analisis menjadi dua tahap: "map" dan "reduce". Penggunaan MapReduce memudahkan untuk melakukan scaling terhadap banyak node computing.</p>

### 3) Yet Another Resource Negotiator (YARN)
<p align="justify">Hadoop YARN adalah komponen utama dalam Apache Hadoop yang mengelola sumber daya dan penjadwalan tugas dalam cluster. YARN memisahkan manajemen sumber daya dari pemrosesan data dan memungkinkan pengolahan data yang besar dan kompleks. Sebelum YARN, Hadoop hanya menggunakan model MapReduce yang memiliki batasan dalam memanfaatkan sumber daya secara efisien. Dengan YARN, Hadoop dapat menjalankan berbagai kerangka kerja pemrosesan data seperti Apache Spark, Apache Flink, dan Apache Storm dalam satu cluster dengan manajemen sumber daya yang optimal. YARN mengalokasikan dan mengelola sumber daya seperti CPU, memori, dan penyimpanan untuk aplikasi yang berjalan di atasnya</p>

### 4) Hadoop Common
<p align="justify">Hadoop Common adalah komponen inti dari platform Apache Hadoop. Ini menyediakan serangkaian perpustakaan dan utilitas yang digunakan oleh komponen-komponen lain dalam ekosistem Hadoop. Hadoop Common menyediakan layanan dan fungsionalitas dasar yang dibutuhkan oleh aplikasi-aplikasi yang berjalan di atas Hadoop.</p>

## **Installation**
<p align="justify">Berikut adalah langkah-langkah umum untuk menginstal Hadoop :</p>
<p align="justify">1. Unduh Hadoop melalui situs resmi Apache Hadoop (https://hadoop.apache.org)</p> 
<p align="justify">2. Ekstrak paket Hadoop yang telah diunduh ke direktori sistem</p>
<p align="justify">3. Install Hadoop native IO binary</p>
<p align="justify">4. (Opsional) Instalasi Java JDK</p>
<p align="justify">5. Konfigurasi Environment Variable</p>
<p align="justify">6. Konfigurasi Hadoop</p>
<p align="justify">7. Inisialisasi HDFS & bug fix</p>
<p align="justify">8. Memulai HDFS daemon</p>
<p align="justify">9. Memulai YARN daemon</p>
<p align="justify">10. Verifkasi proses Java</p>

## **Wordcount Testing**
<p align="justify">Untuk Wordcount Testing, perbandingan antara Java dan Hadoop, dimana untuk hasil percobaan diambil dari 5 kali testing yang
kemudian diambil nilai rata-ratanya. Hasil percobaan adalah sebagai berikut : <br>
JAVA <br>
10MB: 2,1244s <br>
50MB: 10,4306s <br>
100MB: 31,3466s <br>

Hadoop <br>
10MB: 21,964s <br>
50MB: 28,9392s <br>
100MB: 36,694s <br>
500MB: 47,1064s <br>
1000MB: 83,9734s <br>
</p>

## **Reference**
- https://hadoop.apache.org
- https://aws.amazon.com/emr/details/hadoop/what-is-hadoop/
- https://www.databricks.com/glossary/hadoop-distributed-file-system-hdfs
- https://www.tutorialspoint.com/hadoop/hadoop_mapreduce.htm
- https://www.geeksforgeeks.org/hadoop-yarn-architecture/
