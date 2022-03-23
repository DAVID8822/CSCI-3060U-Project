#!/bin/bash
for i in {1..4}; do
echo "testing expected delete and output delete $i"
diff expectedOutputs/delete/delete_dailytransaction$i output/delete/delete_dailytransaction$i
diff expectedOutputs/delete/delete_out$i.txt output/delete/delete_out$i.txt
done