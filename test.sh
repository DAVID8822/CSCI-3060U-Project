# Start of the testing script for general inputs
#!/bin/bash
chdir inputs
# ls -l | wc -l = size
# This line grabs the amount of files in the dir
END= ls -l | wc -l
for ((i=1;i<=END;i++)); do
# iterate through Inputs folder and send input to function
    cat Inputs/i*.txt | java FrontEnd.java > errors.txt 2>&1
done
end
