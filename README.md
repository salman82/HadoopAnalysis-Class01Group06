# Hadoop vs Java Wordcount Efficiency Analysis
## **Authors**
- Brian Yudha Sandi - 2106637082
- Muhammad Irfan Fakhrianto - 1806200356
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
<p align="justify">Hadoop YARN adalah komponen utama dalam Apache Hadoop yang mengelola resource dan penjadwalan tugas dalam cluster. YARN memisahkan manajemen resource dari pemrosesan data dan memungkinkan pengolahan data yang besar dan kompleks. Sebelum YARN, Hadoop hanya menggunakan model MapReduce yang memiliki batasan dalam memanfaatkan resource secara efisien. Dengan YARN, Hadoop dapat menjalankan berbagai kerangka kerja pemrosesan data seperti Apache Spark, Apache Flink, dan Apache Storm dalam satu cluster dengan manajemen resource yang optimal. YARN mengalokasikan dan mengelola resource seperti CPU, memori, dan penyimpanan untuk aplikasi yang berjalan di atasnya</p>

### 4) Hadoop Common
<p align="justify">Hadoop Common adalah komponen inti dari platform Apache Hadoop. Ini menyediakan serangkaian perpustakaan dan utilitas yang digunakan oleh komponen-komponen lain dalam ekosistem Hadoop. Hadoop Common menyediakan layanan dan fungsionalitas dasar yang dibutuhkan oleh aplikasi-aplikasi yang berjalan di atas Hadoop.</p>

## **Installation**
Berikut adalah langkah-langkah instalasi Hadoop dalam bentuk markdown:

### **1) Persiapan Awal**

- Pastikan sistem operasi yang digunakan sudah terpasang dan dikonfigurasi dengan benar.
Unduh paket instalasi Hadoop dari situs resmi Apache Hadoop: <br>
https://hadoop.apache.org/ <br>
- Pastikan versi Hadoop yang diunduh sesuai dengan kebutuhan.

### **2) Ekstraksi Paket**
- Buka terminal atau command prompt.
- Pindah ke direktori tempat menyimpan paket instalasi Hadoop.
- Ekstrak paket instalasi dengan menggunakan perintah berikut:

### **3) Konfigurasi Environment**
- Buka file .bashrc atau .bash_profile di direktori home.
- Tambahkan baris-baris berikut di akhir file:
```
# Set Hadoop-related environment variables
export HADOOP_HOME=/path/to/hadoop
export PATH=$PATH:$HADOOP_HOME/bin
export PATH=$PATH:$HADOOP_HOME/sbin
```
Note: ganti /path/to/hadoop dengan direktori Hadoop yang diekstrak pada langkah sebelumnya

### **4) Konfigurasi Hadoop**
- Buka folder hadoop yang telah diekstrak sebelumnya.
- Buka file etc/hadoop/hadoop-env.sh untuk mengatur variabel environment Hadoop.
- Temukan baris yang mengatur JAVA_HOME dan pastikan variabel tersebut menunjuk ke direktori instalasi Java yang sesuai. Untuk penggunaan kami, kami menggunakan Java versi 1.8.
```
export JAVA_HOME= C:\Java\jdk1.8.0_202
```

### **5) Konfigurasi Cluster Hadoop**
- Buka file etc/hadoop/core-site.xml dan tambahkan konfigurasi berikut:
```
<configuration>
    <property>
        <name>fs.defaultFS</name>
        <value>hdfs://localhost:9000</value>
    </property>
</configuration>
```

- Buka file etc/hadoop/hdfs-site.xml dan tambahkan konfigurasi berikut:
```
<configuration>
  <property>
    <name>dfs.replication</name>
    <value>1</value>
  </property>
  <property>
    <name>dfs.namenode.name.dir</name>
    <value>/C:/hadoop/data/namenode</value>
  </property>
  <property>
    <name>dfs.datanode.data.dir</name>
    <value>/C:/hadoop/data/datanode</value>
  </property>
</configuration>
```
- Buka file etc/hadoop/mapred-site.xml dan tambahkan konfigurasi berikut:
```
<configuration>
    <property>
        <name>mapreduce.framework.name</name>
        <value>yarn</value>
    </property>
</configuration>
```
- Buka file etc/hadoop/yarn-site.xml dan tambahkan konfigurasi berikut:
```
<configuration>
  <property>
    <name>yarn.nodemanager.aux-services</name>
    <value>mapreduce_shuffle</value>
  </property>
  <property>
    <name>yarn.nodemanager.auxservices.mapreduce.shuffle.class</name>
    <value>org.apache.hadoop.mapred.ShuffleHandler</value>
  </property>
</configuration>
```
### **6) Inisialisasi HDFS**
Buka terminal atau command prompt.
Jalankan perintah berikut untuk membuat direktori yang dibutuhkan oleh Hadoop:
```
hdfs namenode -format
```

### **7) Memulai Daemons Hadoop**
- Masih di terminal atau command prompt yang sama, jalankan perintah berikut untuk memulai daemons Hadoop:
```
start-dfs.sh
start-yarn.sh
```

### **8) Verifikasi Instalasi**
- Buka web browser dan kunjungi http://localhost:50070 untuk mengakses Hadoop NameNode web UI.
- Pastikan tampilan web UI muncul tanpa kesalahan.
- Selanjutnya, kunjungi http://localhost:8088 untuk mengakses YARN Resource Manager web UI.
- Pastikan juga tampilan web UI YARN muncul tanpa kesalahan.

## **Wordcount Testing**
<p align="justify">Penulis menguji kemampuan Hadoop dengan memberikan file ukuran 10 MB, 50 MB, 100 MB, 500 MB dan 1 GB berisi kata-kata dari lagu “Never Gonna Give You Up” yang di-generate secara acak dengan sebuah program. Kelima file ini dijalankan pada program MapReduce di Hadoop untuk mencari jumlah setiap kata yang ada di dalamnya.</p>
Selain menjalankan program ini di Hadoop, sebuah program Java lain yang tidak menggunakan Hadoop dibuat sebagai perbandingan dengan MapReduce Hadoop.

## **Reference**
- https://hadoop.apache.org
- https://www.tutorialspoint.com/hadoop/hadoop_enviornment_setup.htm
- https://aws.amazon.com/emr/details/hadoop/what-is-hadoop/
- https://www.databricks.com/glossary/hadoop-distributed-file-system-hdfs
- https://www.tutorialspoint.com/hadoop/hadoop_mapreduce.htm
- https://www.geeksforgeeks.org/hadoop-architecture/
- https://www.geeksforgeeks.org/hadoop-yarn-architecture/
