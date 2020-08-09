import os,sys
import xml.etree.ElementTree as etree

def run():
    tree = etree.ElementTree(file='pom.xml')

    root = tree.getroot()
    for child in root:
        name = child.tag
        pos = name.index("}")
        if pos >= 0:
            schema = name[0:name.index("}")+1]
        else:
            schema = ""
        break

    parent = tree.find(schema + "parent")

    artifactId = tree.find(schema + "artifactId")
    if artifactId == None:
        artifactId = parent.find(schema + "artifactId")

    version = tree.find(schema + "version")
    if version == None:
        version = parent.find(schema + "version")

    jar_path = "target/" + artifactId.text + "-" + version.text + ".jar"

    # java -jar ${project.build.directory}/${project.artifactId}-${project.version}-fat.jar argv[1] argv[2] ....
    cmd = "java -jar " + jar_path + (" ".join(sys.argv[1:]))

    print(cmd)
    os.system(cmd)

run()


