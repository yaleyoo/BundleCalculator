# Bundle Calculator

## Context
Social media Influencers have been basing the price of their social media post on a single post basis. So If a brand required 10 posts (for example spread over a period) then they would be charged 10x the cost of a single post. TRIBE has decided to allow social media influencers to sell posts in bundles and charge the brand on a per bundle basis. So if the Influencer sold image based posts in bundles of 5 and 10 and brand ordered 15 they would get a bundle of 10 and a bundle of 5.

TRIBE currently allows the influencer to monitise the following submission formats:

Submission format | Format code | Bundles
----------------- | ----------- | -------
Image | IMG | 5 @ $450 10 @ $800
Audio | Flac | 3 @ $427.50 6 @ $810 9 @ $1147.50
Video | VID | 3 @ $570 5 @ $900 9 @ $1530

## Task

Given a brands order, you are required to determine the cost and bundle breakdown for each submission format. For simplicity, each order should contain the minimal number of bundles.

### Input:
Each order has a series of lines with each line containing the number of items followed by the submission format code
An example input:
```
10 IMG
15 FLAC
13 VID
```

### Output:
A successfully passing test(s) that demonstrates the following output: (The format of the output is not important)
```
10 IMG $800
  1 x 10 $800
15 FLAC $1957.50
  1 x 9 $1147.50
  1 x 6 $810
13 VID $2370
  2 x 5 $1800
  1 x 3 $570
```

### Solution:
Given a list of bundle size [9,5,3], iterate all the possible combination of 9.

For example, in case of input number is 19:
1. Case 1: the combination with no 9. [0,19]
2. Case 2: the combination with a 9. [9,10]
3. Case 3: the combination with two 9. [18,1]

For each of those combinations, recursively find out the possible combinations of the remaining part.
For example, the remainder of Case 1 is 19, then iterate all the possible combination of 5.

Until reach the very last element in the bundle list. Using the last bundle to fill the remainder.

### Run:
- Required jdk 1.8+
- Define the inputs and example (given example in inputFormat.txt and submissionFormat.txt). ***NOTE: Don't Modify the File Name!***
    - *inputFormat.txt*
    
        Define your inputs in this file. In format of:
        
        'quantity formatCode'
        
        **e.g.**
        > 11 VID
    - *submissionFormat.txt*
    
        Define your Submission format and Bundles in this file. In format of: 
        
        'Submission,FormatCode,n@priceOfBundel1 n@priceOfBundle2'
        
        **e.g.** 
        > Image,IMG,5@$450 10@$800