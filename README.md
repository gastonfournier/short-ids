![](https://api.travis-ci.org/gastonfournier/short-ids.svg?branch=master)

# SUUID is a wrapper around java.util.UUID shortening its String representation

You can use it as:

```java
SUUID suuid = SUUID.randomSUUID();
System.out.println(suuid);
System.out.println(suuid.getUuid()); // unwrap the internal UUID
```

Will output something like:

```
nbPZYF4nQoKYdIsOLnUKIg
9db3d960-5e27-4282-9874-8b0e2e750a22
```

An existing UUID can be wrapped using SUUID constructor:

```java
UUID uuid = UUID.randomUUID();
SUUID suuid = new SUUID(uuid);
```

To obtain an SSUID from its String representation:
```java
SUUID suuid = SUUID.fromBase64("nbPZYF4nQoKYdIsOLnUKIg");
```

# Implementation details
Following there's a simple example to show how we can shorten the length of an UUID by changing its representation

If you run the ShortUuids class you'll get an output like this:

```
f4543acf-68a0-4b23-a7de-8a3587199c76 length: 36
f4543acf68a04b23a7de8a3587199c76 length: 32
11110100010101000011101011001111011010001010000001001011001000111010011111011110100010100011010110000111000110011001110001110110 length: 128
D0VDrPaKBLI6feijWHGZx2 length: 22
```

If you find this useful you should check on this site: http://hashids.org

If you want to understand the probabilities of a collision: https://en.wikipedia.org/wiki/Universally_unique_identifier#Collisions 
and here you can find an analysis based on the range of representable values 
http://preshing.com/20110504/hash-collision-probabilities/ 

There's also this blog post that inspired me to do this: http://www.singular.co.nz/2007/12/shortguid-a-shorter-and-url-friendly-guid-in-c-sharp/

This is my blogpost about it: http://www.gastonfournier.com.ar/post/ids/shortening-uuids/

# Alternatives / similar implementations
- https://github.com/oculus42/short-uuid
- https://github.com/ai/nanoid/ (alternative to UUID)
