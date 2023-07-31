![GitHub stars](https://img.shields.io/github/stars/saksham2105/lombok) 
[![Maintenance](https://img.shields.io/badge/maintained-yes-green.svg)](https://github.com/saksham2105/lombok/commits/master)
[![Website shields.io](https://img.shields.io/badge/website-up-yellow)]()


### Project Lombok
![IMAGE ALT TEXT HERE](https://github.com/saksham2105/lombok/blob/main/feature-image-lombok.png)

----

#### Annotations
* @Setter -> For generating Setter Boilerplate Code for Fields (Applicable on class as well field level)
* @Getter -> For generating Getter Boilerplate Code for Fields (Applicable on class as well field level)
* @Data -> For generating Setter & Getter Boilerplate Code for Fields at the same time (Applicable on class as well as field level)
* @NoArgsConstructor -> For Generating Default Constructor (Applicable on class level)
* @AllArgsConstructor -> For Generating All Arguments Constructor for all fields (Applicable on class level)
* @ToString -> For Generating ToString Method inside class (Applicable on class level)

----

#### Clone

- Clone this repo to your local machine.

---
## Features 📋
* User Don't need to write monotonous BoilerPlate Code
* Lombok Can Generate Setter and Getter by Just Writting Respective @Setter & @Getter Annotation seperately over the class or fields
* Lombok can generate Setter & Getter Both at the same time by Using Data annotation over the class or fields
* Lombok can generate No arguments Constructor by placing @NoArgsConstructor annotation over tha class
* Lombok can generate All arguments Constructor by placing @AllArgsConstructor annotation over tha class
* Lombok can generate To String method by placing @ToString annotation over tha class

---

## Tools and Technologies Used 
* Java
* Java Reflection API for scanning classes
* Javassist Libray for ByteCode Manipulation on Java .class Files
