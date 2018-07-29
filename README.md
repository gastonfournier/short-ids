![](https://api.travis-ci.org/gastonfournier/short-ids.svg?branch=master)

# Short ids
A simple example to show how we can shorten the length of an UUID by changing it's representation

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
