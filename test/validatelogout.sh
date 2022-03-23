#!/bin/bash
for i in {1..4}; do
echo "testing expected logout and output logout $i"
diff expectedOutputs/logout/logout_dailytransaction$i output/logout/logout_dailytransaction$i
diff expectedOutputs/logout/logout_out$i.txt output/logout/logout_out$i.txt
done