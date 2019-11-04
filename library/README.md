
#### How to do a release
```
mvn clean assembly:single release:prepare
mvn release:perform
```

##### A thing I had to do one time
```
export GPG_TTY=$(tty)
```
