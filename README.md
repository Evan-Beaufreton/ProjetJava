# ProjetJava
Projet Java/JavaFx/Bdb, Evan, Alex, Kacem, Gwendal
https://github.com/PapierToilette/ProjetJava

Recuperer les fichiers:
- Premiere fois: git clone "http du repository"
- git pull origin main

Ajouter les fichiers suivant:
- https://drive.google.com/file/d/1cBcHUOeofUKwQxs2nb-EOFrvAiIQNA9i/view?usp=drive_link liens pour telecharger le zip
- Mettre le dossier du zip dans la racine du projet git (pas dans ProjetJava_Eclipse)
- Mettre le fichier webkit si il est pas présent : "C:\........\ProjetJava\openjfx-15_windows-x64_bin-sdk\javafx-sdk-15\bin\ICI"

Avant de push quoi que ce soit, penser a mettre cette commande dans git bash: (pour éviter les problèmes)
- git config --global core.autocrlf input 

Mettre a jour les fichiers:
- git add .
- git commit -m "Message" (Mettez un message meme nul car sinon vous aller avoir une fenetre pour ajouter un message donc relou)
- git pull origin main
- git push origin main