mvn clean compile assembly:single
mv target/Crawler-0.0.1-SNAPSHOT-jar-with-dependencies.jar $HOME/crawl.jar
crontab -l > mycron
echo "*/5 * * * * java -jar $HOME/crawl.jar" >> mycron
crontab mycron
rm mycron
