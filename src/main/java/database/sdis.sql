-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3307
-- Généré le : jeu. 24 avr. 2025 à 13:51
-- Version du serveur : 11.3.2-MariaDB
-- Version de PHP : 8.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `sdis`
--

-- --------------------------------------------------------

--
-- Structure de la table `caserne`
--

DROP TABLE IF EXISTS `caserne`;
CREATE TABLE IF NOT EXISTS `caserne` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `caserne`
--

INSERT INTO `caserne` (`id`, `nom`) VALUES
(1, 'Ifs'),
(2, 'Lisieux'),
(3, 'Le Hom'),
(4, 'Caen Folie Couvrechef');

-- --------------------------------------------------------

--
-- Structure de la table `engin`
--

DROP TABLE IF EXISTS `engin`;
CREATE TABLE IF NOT EXISTS `engin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(50) NOT NULL,
  `numero_ordre` varchar(11) NOT NULL,
  `caserne_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_engin_caserne` (`caserne_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `engin`
--

INSERT INTO `engin` (`id`, `type`, `numero_ordre`, `caserne_id`) VALUES
(1, 'Fourgon pompe-tonne', 'FPT01', 3),
(2, 'Véhicule de secours aux victimes', 'VSAV05', 4),
(3, 'Echelle pivotante automatique', 'EPA03', 1);

-- --------------------------------------------------------

--
-- Structure de la table `fonction`
--

DROP TABLE IF EXISTS `fonction`;
CREATE TABLE IF NOT EXISTS `fonction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) NOT NULL,
  `libelle` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

--
-- Déchargement des données de la table `fonction`
--

INSERT INTO `fonction` (`id`, `code`, `libelle`) VALUES
(1, 'CVSR', 'Conducteur de Véhicule de Secours Routier'),
(2, 'CAFPT', 'Chef d\'agrès Fourgon Pompe-Tonne'),
(3, 'EI', 'Equipier Incendie');

-- --------------------------------------------------------

--
-- Structure de la table `grade`
--

DROP TABLE IF EXISTS `grade`;
CREATE TABLE IF NOT EXISTS `grade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

--
-- Déchargement des données de la table `grade`
--

INSERT INTO `grade` (`id`, `libelle`) VALUES
(1, 'Auxiliaire, Hommes du Rang et Caporaux'),
(2, 'Sous-Officiers'),
(3, 'Officiers'),
(4, 'Emplois Supérieurs de Direction');

-- --------------------------------------------------------

--
-- Structure de la table `intervention`
--

DROP TABLE IF EXISTS `intervention`;
CREATE TABLE IF NOT EXISTS `intervention` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lieu` varchar(50) NOT NULL,
  `dateInter` varchar(50) NOT NULL,
  `heureAppel` varchar(50) NOT NULL,
  `heureArrive` varchar(50) NOT NULL,
  `duree` varchar(50) NOT NULL,
  `id_situation` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_situation` (`id_situation`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `intervention`
--

INSERT INTO `intervention` (`id`, `lieu`, `dateInter`, `heureAppel`, `heureArrive`, `duree`, `id_situation`) VALUES
(1, 'Fleury-sur-Orne', '10/12/2024', '23:51', '00:00', '30min', 1),
(2, 'La Grâce De Dieu', '01/03/2025', '10:19', '10:30', '10min', 4),
(3, 'Caen', '14/02/2025', '14:50', '15:00', '16min', 3);

-- --------------------------------------------------------

--
-- Structure de la table `pompier`
--

DROP TABLE IF EXISTS `pompier`;
CREATE TABLE IF NOT EXISTS `pompier` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bip` varchar(10) DEFAULT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) DEFAULT NULL,
  `dateNaissance` date NOT NULL,
  `typePompier` varchar(13) NOT NULL,
  `pro_dernierIndice` varchar(50) DEFAULT NULL,
  `pro_dateObtentionIndice` date DEFAULT NULL,
  `vol_professionLibelle` varchar(100) DEFAULT NULL,
  `vol_professionVille` varchar(100) DEFAULT NULL,
  `fonction_id` int(11) DEFAULT NULL,
  `grade_id` int(11) DEFAULT NULL,
  `caserne_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_pom_caserne` (`caserne_id`),
  KEY `FK_FONCTION_ID` (`fonction_id`),
  KEY `FK_GRADE_ID` (`grade_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `pompier`
--

INSERT INTO `pompier` (`id`, `bip`, `nom`, `prenom`, `dateNaissance`, `typePompier`, `pro_dernierIndice`, `pro_dateObtentionIndice`, `vol_professionLibelle`, `vol_professionVille`, `fonction_id`, `grade_id`, `caserne_id`) VALUES
(1, NULL, 'LEROY', 'Pierrick', '1985-01-01', 'Professionnel', '4,01', '2025-01-01', NULL, NULL, 1, 3, 1),
(2, NULL, 'MASSON', 'Bastien', '1985-01-02', 'Volontaire', NULL, NULL, 'Vendeur H&M', 'Brive', 3, 1, 1),
(3, NULL, 'DUVAL', 'Matthias', '1985-01-03', 'Volontaire', NULL, NULL, 'Barman', 'Caen', 1, 1, 4),
(4, NULL, 'MADJI', 'Walid', '1985-01-04', 'Professionnel', '4,04', '2025-01-04', NULL, NULL, 3, 2, 4),
(6, NULL, 'CHAUVEL', 'Jules', '1985-01-06', 'Professionnel', '4,06', '2025-01-06', NULL, NULL, 1, 2, 1),
(7, NULL, 'CAUVIN', 'Nayah', '1985-01-07', 'Volontaire', NULL, NULL, 'Kinésithérapeute', 'Ifs', 2, 1, 1),
(8, NULL, 'TRAORE', 'Sylvain', '1985-01-08', 'Professionnel', '4,08', '2025-01-08', NULL, NULL, 3, 4, 3),
(9, NULL, 'BOULEAU', 'Line', '1985-01-09', 'Volontaire', NULL, NULL, 'Barman', 'Caen', 2, 2, 3),
(10, NULL, 'MANCEL', 'Florianne', '1985-01-10', 'Volontaire', NULL, NULL, 'Boulangère', 'Etretat', 2, 2, 2),
(11, NULL, 'PONTIER', 'Claire', '1985-01-11', 'Professionnel', '4,11', '2025-01-11', NULL, NULL, 1, 4, 2),
(12, NULL, 'BARON', 'Gwladys', '1985-01-12', 'Volontaire', NULL, NULL, 'Sans-Emploi', 'Bourges', 3, 3, 3),
(13, NULL, 'PASTOR', 'Lucas', '1985-01-13', 'Professionnel', '4,13', '2025-01-13', NULL, NULL, 1, 4, 1),
(14, NULL, 'BAREAU', 'Mila', '1985-01-14', 'Volontaire', NULL, NULL, 'Bûcheronne', 'Feuguerolles-Bully', 1, 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `situation`
--

DROP TABLE IF EXISTS `situation`;
CREATE TABLE IF NOT EXISTS `situation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `situation`
--

INSERT INTO `situation` (`id`, `type`) VALUES
(1, 'feu dans un appartement'),
(2, 'feu de broussailles'),
(3, 'ascenseur bloqué'),
(4, 'malaise');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `engin`
--
ALTER TABLE `engin`
  ADD CONSTRAINT `FK_engin_caserne` FOREIGN KEY (`caserne_id`) REFERENCES `caserne` (`id`);

--
-- Contraintes pour la table `intervention`
--
ALTER TABLE `intervention`
  ADD CONSTRAINT `intervention_ibfk_1` FOREIGN KEY (`id_situation`) REFERENCES `situation` (`id`);

--
-- Contraintes pour la table `pompier`
--
ALTER TABLE `pompier`
  ADD CONSTRAINT `FK_FONCTION_ID` FOREIGN KEY (`fonction_id`) REFERENCES `fonction` (`id`),
  ADD CONSTRAINT `FK_GRADE_ID` FOREIGN KEY (`grade_id`) REFERENCES `grade` (`id`),
  ADD CONSTRAINT `fk_pom_caserne` FOREIGN KEY (`caserne_id`) REFERENCES `caserne` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
