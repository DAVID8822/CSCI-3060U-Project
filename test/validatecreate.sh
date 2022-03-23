#!/bin/bash
for i in {1..4}; do
echo "testing expected create and output create $i"
diff expectedOutputs/create/create_dailytransaction$i output/create/create_dailytransaction$i
diff expectedOutputs/create/create_out$i.txt output/create/create_out$i.txt
done