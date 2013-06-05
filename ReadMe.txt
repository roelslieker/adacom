1. I cannot determine how many words would be the upperlimit. 
I would have to experience this by trial-and-error. I can however make an estimation:

	6 chars + 1 linebreak = 7 bytes per word
	total memory available:		256 * 256 * 256 = 16777216 bytes
	base memory need for program run:	X bytes ?
	memory used by words ONLY:  ( 16777216 - X ) / 7 
	assuming X = 128K = 32768 bytes
	approximate number of words:  (16777216 - 32768) / 7 = 2392064 words
	
	(does that make sense ?)

2. To increase the limit I would read the file in chunks and split per batch processing and then flush the memory.
It would slow down the execution and add some extra coding but it would be able to handle more words.

3. Reading both files into a List and looping through only 1 I think would be reasonably efficient.
Given more time I might be able to come up with something more sophisticated.

4. To increase the execution performance I might read the files (and write the file) in larger chunks 
	therefore minimizing read/write access (not line by line).
	


Roel Slieker
05/06/2013, 15:20