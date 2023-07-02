# Fugerit Document Generation Framework (fj-doc)

## Java EE extension (fj-doc-ent)

[back to fj-doc index](https://github.com/fugerit-org/fj-doc.git)  

*Deprecation* (2022-11-17):  
Previously this module was part of the [Fugerit Doc Venus](https://github.com/fugerit-org/fj-doc.git) and now is formally deprecated and put in an separate repository.

*Description* :  
Helper for generation of [fj-doc XML format](https://www.fugerit.org/data/java/doc/xsd/doc-1-1.xsd) 
though J2EE infrastructure (for example jsp).

*Status* :  
All basic features are implemented, but it needs refactoring.  
This was the original pipeline implementation with the use of [DocServlet](src/main/java/org/fugerit/java/doc/ent/servlet/DocServlet.java)  
Usage of module [fj-doc-freemarker](../fj-doc-freemarker/README.md) is recommended in most scenarios. 

See [CHANGELOG.md](CHANGELOG.md) for details.