# Start of the testing script for search
#!/bin/bash
chdir inputs
# ls -l | wc -l = size
END= ls -l | wc -l
for ((i=1;i<=END;i++)); do
    Inputs/(*i)
done
end
