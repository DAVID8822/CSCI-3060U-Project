#!/bin/bash
for i in {1..4}; do
echo "testing expected rent and output rent $i"
diff expectedOutputs/rent/rent_dailytransaction$i output/rent/rent_dailytransaction$i
diff expectedOutputs/rent/rent_out$i.txt output/rent/rent_out$i.txt
done