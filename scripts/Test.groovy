// To execute: grails run-script scripts/Test.groovy
//--eliminare le sottostanti prime due righe nell'_install.groovy definitivo
String pluginBasedir = "/Users/gac/Documents/IdeaProjects/algoslib/"
String basedir = "/Users/gac/Documents/IdeaProjects/test/"
//--eliminare le sovrastanti prime due righe nell'_install.groovy definitivo

String source
String dest
source = "${pluginBasedir}"
dest = "${basedir}"

//--abilitare le sottostanti due righe nell'_install.groovy definitivo
//--utilizza le special variables provided by Gant
//source = source + "/"
//dest = dest + "/"
//--abilitare le sovrastanti due righe nell'_install.groovy definitivo

//--directory del plugin
String sourceDir = "${source}grails-app/it/algos/algos/"

//--directory dell'applicazione
String appDir = "grails-app/"
String domainDir = "${appDir}domain/"
String jobsDir = "${appDir}jobs/"
String viewsDir = "${appDir}views/"
String templatesDir = "src/templates/"
String artifactsDir = "${templatesDir}artifacts/"
String scaffoldingDir = "${templatesDir}scaffolding/"


print('------------')
print('Algoslib - test dello script')
print('------------')


//--copia tutti i files dalla della directory indicata
//--sposta file RefreshJob
//ab.moveFile(source, dest, "${jobsDir}RefreshJob")
moveFile(source, dest, "${domainDir}Pippoz.groovy")

print('------------')
print('Algoslib - fine test')
print('------------')


public static moveFile(String srcDirPath, String dstDirPath, String fileName) {
    String srcFile = srcDirPath + fileName
    String destFile = dstDirPath + fileName

    copyFile(srcFile, destFile)
    deleteFile(srcFile)
} // fine del metodo


public static copyFile(String srcFile, String destFile) {
    new AntBuilder().copy(file: srcFile, tofile: destFile)
} // fine del metodo

public static deleteFile(String pathFile) {
    new AntBuilder().delete(file: pathFile)
} // fine del metodo