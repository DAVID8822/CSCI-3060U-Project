#!/bin/bash
for i in {1..4}; do
echo "testing expected post and output post $i"
diff expectedOutputs/post/post_dailytransaction$i output/post/post_dailytransaction$i
diff expectedOutputs/post/post_out$i.txt output/post/post_out$i.txt
done