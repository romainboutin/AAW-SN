SOURCE=report

all: pdf

dvi:
	latex $(SOURCE).tex
	latex $(SOURCE).tex

ps: dvi
	dvips $(SOURCE).dvi -o $(SOURCE).ps

view: ps
	kghostview $(SOURCE).ps
	
xview: ps
	gv $(SOURCE).ps

pdf:$(SOURCE).tex
	pdflatex $(SOURCE).tex

ps2pdf:ps
	ps2pdf $(SOURCE).ps $(SOURCE).pdf

pstopdf:ps
	pstopdf $(SOURCE).ps $(SOURCE).pdf

html:
	latex2html $(SOURCE).tex
	
dict:
	aspell --lang=en -c $(SOURCE).tex
	
clean:
	rm -f *~
	rm -f *.aux 
	rm -f *.log
	rm -f *.out
	rm -f *.synctex.gz
	rm -f *.toc 
	rm -f *.bbl
	rm -f *.blg
	rm -f *.bak
	rm -f *.brf
	rm -f .pdfbibtex
	rm -f *#
		
distclean: clean
	rm -f $(SOURCE).dvi
	rm -f $(SOURCE).ps
	rm -f $(SOURCE).pdf
	rm -fr $(SOURCE)
	
.PHONY : all clean distclean
