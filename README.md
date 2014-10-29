biopax-jsonld
=============

A BioPAX to/from JSON-LD format converter.

Requirements:

Needs jdk 1.7 and Jena library verion  2.12.0 or later.
All dependencies outlined in maven pom.xml file.

Maximum tested size of owl file is 400M, it needs PC with minimum 12 G memory as processing of the file involved creation Jena model in the memory. This step is very memory intensive.

How to run for test:
The library can be run from command line as java jar file, example of running command:
java -Xms1024M -Xmx4096M -XX:-UseGCOverheadLimit -jar biopax_jsonld-0.0.1-SNAPSHOT-jar-with-dependencies.jar
Jar has a test owl file for processing imbedded in resources directory of the jar file. Name of the file is PC2v5test-Signaling-By-BMP-Pathway-REACT_12034.2.owl, size 1.4 M.
Output file in jsonld format will be written in jar working directory with the name "test.jsonld".
Reverse conversion of file test.jsonld to rdf format file will produce file "test.rdf" in the same directory.

How to run from java code:
An example how to run conversion methods from java code is main method in JSONLDConverter.java file.
