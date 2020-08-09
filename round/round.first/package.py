import os,sys
cmd = "mvn clean package -Dmaven.test.skip=true " + (" ".join(sys.argv[1:]))
print(cmd)
os.system(cmd)