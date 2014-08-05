Machine Learning Text-Classifier
===============

Classify a sentence into a category using Naive Bayes Algorithm.
The algorithm gives a probability for each category using four different categories. 
Each of them contains around 50 elements for training set.
You need to add the jar weka.jar for the implementation of this algorithm.


Initialization
===============

To initialize the training set, I use Wikipedia database.

First Step 
===============
Go to http://dumps.wikimedia.org/frwiki/ and download the latest alltitles.gz

Second Step  
===============
Use some regex on the text :
Remove all ? : .*[\?].*
Remove all & : .*[\&].*
Remove all categorie title : .*(catégorie).*

Third Step 
===============
Remove the text before the articles names. The code in Wikipedia/RemoveNames.java works for the file frwiki-20140716-all-titles.gz.

Fourth Step 
===============
Execute the code in Wikipedia/GetCategorie.java to associate to each article name the wikipedia category which is assigned.




