# Makefile

# Variables
MVN = mvn
TARGET_DIR = target

# Cible par défaut
default: clean package

# Cible pour nettoyer le projet
clean:
	$(MVN) clean

# Cible pour construire le projet avec Maven
package:
	$(MVN) package
