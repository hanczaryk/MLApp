# MLApp Usage
- Add 1MB to used heap by adding a 1MB object to a vector - http://HOST:PORT/MLApp/MLVectorParam?myaction=add
- Remove last 1MB object from the vector - http://HOST:PORT/MLApp/MLVectorParam?myaction=removeLast
- Remove all objects from the vector - http://HOST:PORT/MLApp/MLVectorParam?myaction=removeAll

# Shell script to add 325 MB (change HOST and PORT values)
```
#!/bin/sh
XEND=325
X=1
while [ $X -le $XEND ]
do
 curl http://HOST:PORT/MLApp/MLVectorParam?myaction=add 2&>1
 X=`expr $X + 1`
done
```

# Shell script to remove 325 MB (change HOST and PORT values)
```
#!/bin/sh
XEND=325
X=1
while [ $X -le $XEND ]
do
 curl http://HOST:PORT/MLApp/MLVectorParam?myaction=removeLast 2&>1
 X=`expr $X + 1`
done
curl http://HOST:PORT/MLApp/GC 2&>1
```
