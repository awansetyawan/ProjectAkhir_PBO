-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 27 Apr 2023 pada 17.04
-- Versi server: 10.4.24-MariaDB
-- Versi PHP: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `galeriseni`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `dataakun`
--

CREATE TABLE `dataakun` (
  `IdAkun` int(100) NOT NULL,
  `Nama` varchar(100) NOT NULL,
  `Username` varchar(100) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `NoRek` varchar(100) NOT NULL,
  `StatusAkun` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `dataakun`
--

INSERT INTO `dataakun` (`IdAkun`, `Nama`, `Username`, `Password`, `NoRek`, `StatusAkun`) VALUES
(1, 'Galeri Seni', 'GaleriSeni', 'GaleriSeni', '12345678910', 'ADMIN');

-- --------------------------------------------------------

--
-- Struktur dari tabel `datapesanan`
--

CREATE TABLE `datapesanan` (
  `IdPesanan` int(100) NOT NULL,
  `IdUser` int(100) NOT NULL,
  `IdSeniman` int(100) NOT NULL,
  `IdBarangSeni` int(100) NOT NULL,
  `NamaUser` varchar(100) NOT NULL,
  `NamaSeniman` varchar(100) NOT NULL,
  `NamaItem` varchar(100) NOT NULL,
  `JumlahItem` int(100) NOT NULL,
  `HargaItem` int(100) NOT NULL,
  `TotalPembayaran` int(100) NOT NULL,
  `NoRekSeniman` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `datasenilukisan`
--

CREATE TABLE `datasenilukisan` (
  `IdLukisan` int(100) NOT NULL,
  `IdSeniman` int(100) NOT NULL,
  `Seniman` varchar(100) NOT NULL,
  `Nama` varchar(100) NOT NULL,
  `Teknik` varchar(100) NOT NULL,
  `Aliran` varchar(100) NOT NULL,
  `TahunPublikasi` varchar(100) NOT NULL,
  `Harga` int(100) NOT NULL,
  `Panjang` int(100) NOT NULL,
  `Lebar` int(100) NOT NULL,
  `Stok` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `datasenipatung`
--

CREATE TABLE `datasenipatung` (
  `IdPatung` int(100) NOT NULL,
  `IdSeniman` int(100) NOT NULL,
  `Seniman` varchar(100) NOT NULL,
  `Nama` varchar(100) NOT NULL,
  `Jenis` varchar(100) NOT NULL,
  `TahunPublikasi` varchar(100) NOT NULL,
  `Harga` int(100) NOT NULL,
  `Panjang` int(100) NOT NULL,
  `Lebar` int(100) NOT NULL,
  `Tinggi` int(100) NOT NULL,
  `Stok` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `dataseniukir`
--

CREATE TABLE `dataseniukir` (
  `IdUkir` int(100) NOT NULL,
  `IdSeniman` int(100) NOT NULL,
  `Seniman` varchar(100) NOT NULL,
  `Nama` varchar(100) NOT NULL,
  `Motif` varchar(100) NOT NULL,
  `TahunPublikasi` varchar(100) NOT NULL,
  `Harga` int(100) NOT NULL,
  `Panjang` int(100) NOT NULL,
  `Lebar` int(100) NOT NULL,
  `Tinggi` int(100) NOT NULL,
  `Stok` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `datatransaksi`
--

CREATE TABLE `datatransaksi` (
  `IdTransaksi` int(100) NOT NULL,
  `IdPesanan` int(100) NOT NULL,
  `IdUser` int(100) NOT NULL,
  `NoRekSumber` varchar(100) NOT NULL,
  `NoRekTujuan` varchar(100) NOT NULL,
  `NamaUser` varchar(100) NOT NULL,
  `NamaSeniman` varchar(100) NOT NULL,
  `Item` varchar(100) NOT NULL,
  `JumlahItem` int(100) NOT NULL,
  `TotalTransaksi` int(100) NOT NULL,
  `TanggalTransaksi` varchar(100) NOT NULL,
  `Alamat` varchar(100) NOT NULL,
  `Email` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `dataakun`
--
ALTER TABLE `dataakun`
  ADD PRIMARY KEY (`IdAkun`);

--
-- Indeks untuk tabel `datapesanan`
--
ALTER TABLE `datapesanan`
  ADD PRIMARY KEY (`IdPesanan`);

--
-- Indeks untuk tabel `datasenilukisan`
--
ALTER TABLE `datasenilukisan`
  ADD PRIMARY KEY (`IdLukisan`);

--
-- Indeks untuk tabel `datasenipatung`
--
ALTER TABLE `datasenipatung`
  ADD PRIMARY KEY (`IdPatung`);

--
-- Indeks untuk tabel `dataseniukir`
--
ALTER TABLE `dataseniukir`
  ADD PRIMARY KEY (`IdUkir`);

--
-- Indeks untuk tabel `datatransaksi`
--
ALTER TABLE `datatransaksi`
  ADD PRIMARY KEY (`IdTransaksi`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `dataakun`
--
ALTER TABLE `dataakun`
  MODIFY `IdAkun` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT untuk tabel `datapesanan`
--
ALTER TABLE `datapesanan`
  MODIFY `IdPesanan` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT untuk tabel `datasenilukisan`
--
ALTER TABLE `datasenilukisan`
  MODIFY `IdLukisan` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT untuk tabel `datasenipatung`
--
ALTER TABLE `datasenipatung`
  MODIFY `IdPatung` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT untuk tabel `dataseniukir`
--
ALTER TABLE `dataseniukir`
  MODIFY `IdUkir` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT untuk tabel `datatransaksi`
--
ALTER TABLE `datatransaksi`
  MODIFY `IdTransaksi` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
