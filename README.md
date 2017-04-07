biopax-jsonld
=============

__Note:__ the BioPAX to JSON converter is now part of [Paxtools](https://github.com/BioPAX/Paxtools/), and this (unfinished) project is now obsolete (useful to anyone?).

A BioPAX to/from JSON-LD format converter.

Run (a quick "test"):

`java -Xmx4g -XX:-UseGCOverheadLimit -jar biopax_jsonld-0.0.1-SNAPSHOT-jar-with-dependencies.jar`

The JAR contains a test BioPAX file: PC2v5test-Signaling-By-BMP-Pathway-REACT_12034.2.owl, size 1.4 M.
The command produces test.jsonld in the working directory. Reverse conversion of that file back to 
BioPAX format generates test.rdf file in the same folder.

API:
Main method in JSONLDConverter.java is an example.

To convert a BioPAX (RDF/XML) data file to JSON-LD format, use JSONLDInterface:

convertToJSONLD(InputStream in, OutputStream os).

To convert from JSON-LD to RDF:

convertFromJSONLD(InputStream in,OutputStream out)
