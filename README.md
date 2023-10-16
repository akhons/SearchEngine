# SearchEngine

From the home jsp file we are expecting 2 inputs- URL to be webcrawled and a keyword to search in the text contents of this URL.
used sendredirect to redirect control to a servlet file which is responsible for webcrawling that URL.
used Jsoup library in java to do the webcrawling.
Stored the text contents we got after webcrawling to a mysql database using Hibernate with 'id' as a primary key, 'Url' column for storing the searched URL and a 'Text_data' column for storing the 
text contents of the URL.
A pattern searching algorithm was required to search if a particular keyword was in the text contents of the URL. From GeeksForGeeks I found an algorithm called 'Boyer Moore algorithm'
for pattern searching and implemented it into my code.
Takes URL and keyword as inputs-
![image](https://github.com/akhons/SearchEngine/assets/116623774/c252f98f-0363-48fd-b1b9-80b306ca7485)

Just prints "Data Found!!!" on the web page at "http://localhost:8081/SearchEngine/KeySearch" if the keyword is present in the contents of the URL.

![image](https://github.com/akhons/SearchEngine/assets/116623774/466136cf-5c81-44e9-ae57-699b0273dd45)

Data stored in mysql database -
![image](https://github.com/akhons/SearchEngine/assets/116623774/4a9f5033-8a2f-444e-b121-b374ccd56642)

extracted the data from the database into another file-
![image](https://github.com/akhons/SearchEngine/assets/116623774/0852b3d7-f75a-4cb9-95ea-5cbb637e6d1d)
