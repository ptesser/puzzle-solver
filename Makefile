# Makefile da inserire nella root dei sorgenti del progetto.

parte2:
	@if [ ! -d parte2 ]; then
		mkdir part2
		cp -r src parte1/src
		cp -r input_files parte2/input_files
		cp -r output_files parte2/output_files
		cp -r relazione/documenti_finali parte2/relazione
	else
		echo "Cartella già presente. Non serve creare una nuova struttura!";
	fi

doc:
	rm relazione/documenti_finali/relazione_parte_1.pdf
	cp relazione/documentazione/relazione_parte_1/relazione_parte_1.pdf relazione/documenti_finali/relazione_parte_1.pdf
	@echo "Copia documenti finali completata."

clean:
	rm -r parte1;
	@echo "Cartella parte1 rimossa";