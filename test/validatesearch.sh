#!/bin/bash
for i in {1..4}; do
echo "testing expected search and output search $i"
diff expectedOutputs/search/search_dailytransaction$i output/search/search_dailytransaction$i
diff expectedOutputs/search/search_out$i.txt output/search/search_out$i.txt
done