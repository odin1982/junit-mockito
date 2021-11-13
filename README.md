# junit-mockito
## WHAT YOU NEED FOR THIS BOOK  
> java 1.6 or newer  
> mockito 1.9.5  
> assertj 1.6.0  

## LINKS
Introducing BDD --> http://dannorth.net/introducing-bdd/

## ADDING MOCKITO
### MAVEN
```
<dependency>
<groupId>org.mockito</groupId>
<artifactId>mockito-all</artifactId>
<version>1.9.5</version>
<scope>test</scope>
</dependency>
```

### GRADLE
~~~
testCompile "org.mockito:mockito-all:1.9.5"
~~~


## ANNOTATIONS
@Mock:  This is used for mock creation  
@Spy:   This is used to create a spy instance  
@InjectMocks: This is used to instantiate the @InjectMock annotated field and inject all the @Mock or @Spy annotated fields into it (if applicable)  
@Captor : This is used to create an argument captor


## ADDING JUNIT
```
<dependency>
<groupId>junit</groupId>
<artifactId>junit</artifactId>
<version>4.11</version>
<scope>test</scope>
</dependency>
```