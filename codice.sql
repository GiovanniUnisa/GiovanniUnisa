DROP Database if exists METALS_CORPORATION;
CREATE DATABASE METALS_CORPORATION;
USE METALS_CORPORATION;

create table utente(
id int(11) not null auto_increment primary key,
username varchar(45) not null unique key,
passwordhash char(40) not null,
nome varchar(100) not null,
email varchar(100) not null unique key,
`admin` tinyint(1) not null 
);

CREATE TABLE login (
  id char(36) not null primary key,
  idutente int(11) not null,
  token char(36) not null, 
  KEY(idutente),
  CONSTRAINT FOREIGN KEY (idutente) REFERENCES utente (id)   
);


create table prodotto(
id int not null primary key auto_increment,
nome varchar(40) not null,
descrizione longtext not null,
prezzoBase float not null,
iva double not null,
FULLTEXT KEY(nome,descrizione),
FULLTEXT KEY(nome)
);

CREATE TABLE categoria (
  id int(11) not null auto_increment primary key,
  nome varchar(45) not null,
  descrizione varchar(45) not null 
);

CREATE TABLE prodotto_categoria (
  idprodotto int(11) not null,
  idcategoria int(11) not null,
  PRIMARY KEY (idprodotto,idcategoria),
  CONSTRAINT FOREIGN KEY (idprodotto) REFERENCES prodotto (id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT FOREIGN KEY (idcategoria) REFERENCES categoria (id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE ordine(
id int not null primary key auto_increment,
prezzo varchar(45),
indirizzo varchar(45) not null
);

CREATE TABLE utente_ordine (
  idutente int(11) not null,
  idordine int(11) not null,
  PRIMARY KEY (idutente,idordine),
  CONSTRAINT FOREIGN KEY (idutente) REFERENCES utente (id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT FOREIGN KEY (idordine) REFERENCES ordine (id) ON DELETE CASCADE ON UPDATE CASCADE
);


LOCK TABLES prodotto WRITE;
INSERT INTO prodotto
VALUES  (1,'Acciaio per Bonifico','Gli acciai inossidabili sono caratterizzati da una maggior resistenza alla ossidazione e alla corrosione, specie in aria umida o in acqua dolce. Tale capacità è dovuta principalmente alla presenza del cromo, nella lega, in grado di passivarsi e cioè di ricoprirsi di uno strato sottile e aderente di ossidi, praticamente invisibile dello spessore pari a pochi strati atomici, che protegge superficialmente il metallo o la lega sottostante.',5000,22),
		(2,'Acciaio per Cemento','L acciaio per calcestruzzo armato è prodotto in stabilimento sotto forma di barre o rotoli, reti o tralicci, per l utilizzo diretto in cantiere o come elementi base per le successive trasformazioni.',3500,22),
		(3,'Acciaio per Cuscinetti','Gli acciai per cuscinetti, definiti anche “a tutta tempra”, sono quelli tipici al cromo e con carbonio 1%. Dopo tempra in olio, presentano minime deformazioni ed elevata durezza, resistenza all usura ed alla compressione.',8500,22),
        (4,'Acciaio per Molla','L acciaio armonico è un acciaio al silicio ad alto tenore di carbonio (0,80 - 0,90 %), quindi particolarmente duro (durezza 240 della scala di Brinell, carico di rottura 1400-1700 N/mm², carico di snervamento 1150 N/mm², allungamento 5%), temprato in olio 780-800 °C. Con la ricottura diventa plastico; una volta formato, si procede alla tempra, e acquisisce elasticità.',14500,22),
        (5,'Acciaio Inox Austetico','La composizione base dell acciaio inossidabile austenitico è il 18% di Cr e l 8% di Ni. Una percentuale del 2-3% di molibdeno permette la formazione di carburi di molibdeno migliori rispetto a quelli di cromo e assicura una miglior resistenza alla corrosione dei cloruri',6500,22),
		(6,'Acciaio Inox Ferritico','Gli acciai ferritici sono acciai inossidabili al solo cromo (variabile dall’11% al 30%) come i martensitici, ma rispetto a questi ultimi sono ad un minor tenore di carbonio. Altri elementi presenti nei ferritici sono il molibdeno, l’alluminio (per aumentare la resistenza all’ossidazione a caldo) e lo zolfo (per facilitarne la lavorabilità).',4000,22),
        (7,'Acciaio Inox Martensitico','L acciaio inox martensitico ha caratteristiche meccaniche molto elevate ed è ben lavorabile alle macchine, è l unico acciaio inox che può prendere la tempra e pertanto aumentare le sue proprietà meccaniche',5000,22),
        (8,'Lega 2011','Lega alluminio da estrusione, con alligante il rame che conferisce resistenza meccanica. Si tratta di una lega con ottime caratteristiche di lavorabilità all utensile',2500,22),
        (9,'Lega 6060','Lega alluminio-magnesio-silicio, di impiego generale, caratterizzata da ottima estrudibilità, che consente la realizzazionedi sezioni anche di notevole complessità e con pareti sottili; resistenza non elevata; buona restenza alla corrosione.',2500,22),
		(10,'Lega 6082','Lega alluminio-silicio-magnesio-manganese di impiego generale, caratterizzata da buoni valori di resistenza, al vertice delleleghe 6000; buona resistenza alla corrosione; ottima saldabilità, buona lavorabilità alle macchine utensili.',2500,22),
        (11,'Lega 7075','Lega d alluminio in cui il principale alligante è lo zinco, elemento che la solubilità più elevata nell alluminio. Lo zinco aumenta la durezza, oltre a favorire l autotemprabilità della lega. Le leghe appartenenti a questa serie (7000), trattate termicamente, hanno la più elevata resistenza a trazione di tutte le leghe d alluminio',8900,22),
        (12,'Bronzo Alluminio','I cuprallumini (più noti come bronzi all alluminio) sono leghe di rame in cui l alluminio è l elemento aggiuntivo principale. Le più diffuse contengono dal 5 al 12% di alluminio, spesso insieme con ferro, nichel, manganese. Sono note per la loro notevole resistenza meccanica e alla corrosione; sono impiegate anche in presenza di fluidi ad alta velocità. In alcune applicazioni possono sostituire leghe più costose, come i bronzi allo stagno.',2500,22),
        (13,'Bronzo b14','B14 UNI 1701. Lega binaria composta da rame e stagno ideale per la produzione di particolari filettati o dentati',6900,22),		
        (14,'Bronzo Meccanico','Questa lega composta principalmente di rame (Cu), viene arricchita con stagno (Sn) fino all 8-9%, dando luogo a leghe con buone caratteristiche meccaniche e grande resistenza alla corrosione: queste leghe sono ancora lavorabili plasticamente e si possono laminare, estrudere, forgiare, stampare e trafilare. ',10000,22),
        (15,'Ottone','L ottone è una lega ossidabile formata da rame (Cu) e zinco (Zn), simile all oricalco.Gli ottoni contenenti dal 40 al 60% di stagno, molto plastici, sono nominati similori, per via della colorazione simile a quella dell oro. Vengono impiegati in bigiotteria con i quali si producono orologi.',2800,22),
		(16,'Rame','l rame è un metallo rosato o rossastro, di conducibilità elettrica e termica elevatissima, superata solo da quelle dell argento; è molto resistente alla corrosione (per via di una patina aderente che si forma spontaneamente sulla superficie, prima di colore bruno e poi di colore verde o verde-azzurro) e non è magnetico.',5500,22);        
 UNLOCK TABLES;         
       
       
LOCK TABLES categoria WRITE;   
INSERT INTO categoria
VALUES (1,"Acciaio","Prodotti in Acciaio"),
	   (2,"Acciaio Inox","Prodotti in Acciaio Inox"),
	   (3,"Rame","Prodotti in Rame"),
	   (4,"Bronzo","Prodotti in Bronzo"),
	   (5,"Ottone","Prodotti in Ottone"),
       (6,"Alluminio","Prodotti in Alluminio");       
UNLOCK TABLES;
   
    
LOCK TABLES prodotto_categoria WRITE;       
INSERT INTO prodotto_categoria
VALUES (1,1),(2,1),(3,1),(4,1),(5,2),(6,2),(7,2),(8,6),(9,6),(10,6),(11,6),(12,4),(13,4),(14,4),(15,5),(16,3);
UNLOCK TABLES; 
    
      
LOCK TABLES utente WRITE;
INSERT INTO utente VALUES (1,'Giovanni',SHA1('password1'),'Utente 1','utente1@libero.it',1),(2,'Alessandra',SHA1('password2'),'Utente 2','utente2@gmail.com',0),(3,'Rosario',SHA1('password3'),'Utente 3','utente3@gmail.com',0);
UNLOCK TABLES;


