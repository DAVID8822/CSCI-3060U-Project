# Start of the testing script for search
#!/bin/bash
chdir inputs
# ls -l | wc -l = size
# This line grabs the amount of files in the dir
END= ls -l | wc -l
for ((i=1;i<=END;i++)); do
# iterate through Inputs folder and send input to function
    cat Inputs/(*i) | java FrontEnd.java
done
end
