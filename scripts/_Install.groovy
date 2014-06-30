/*
 * Main script to setup algoslib on installation
 */

//--utilizza le special variables provided by Gant
String source = "${pluginBasedir}"
String dest = "${basedir}"
source = dest + "/" + source + "/"
dest = dest + "/"

//--directory dell'applicazione
String appDir = "grails-app/"

// copy readme into project
moveFile(source, dest, "${appDir}README", "README-Lib")

print('------------')
print('Algoslib - creato (o sovrascritto) README-Lib')
print('------------')


public static moveFile(String srcDirPath, String dstDirPath, String srcFileName, String dstFileName) {
    String srcFile = srcDirPath + srcFileName
    String destFile = dstDirPath + dstFileName

    copyFile(srcFile, destFile)
} // fine del metodo


public static copyFile(String srcFile, String destFile) {
    new AntBuilder().copy(file: srcFile, tofile: destFile, overwrite: true)
} // fine del metodo

