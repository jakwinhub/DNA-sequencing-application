package main.java.com.dnasequencing.analysis;

// usage of own classes.

import main.java.com.dnasequencing.utils.DNAUtils;
import main.java.com.dnasequencing.utils.FileUtils;
import main.java.com.dnasequencing.utils.LoggerUtils;

// usage of external Libraries.

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

// DNA_Sequencing_Application Class is responsible for  coordinating the analysis of a DNA sequence,
// including transcribing it to RNA, translating it to protein, and finding codon positions.

public class DNAAnalyzer {
    // usage of Logger for robuster logging during runtime. Can be replaced by ex.printStackTrace().
    private static final Logger logger = LoggerUtils.getLogger();

    // Sequences to be analyzed. RNA is transcribed from the DNA String during analyzing process.
    private final String dnaSequence;
    private final String rnaSequence;

    /**
     * Constructor initializing dnaSequence field and transcribes DNA-Sequence to RNA using the DNATranscriber class.
     *
     * @param dnaSequence String out of chosen file.
     */
    public DNAAnalyzer(String dnaSequence) {
        this.dnaSequence = dnaSequence;
        this.rnaSequence = DNATranscriber.transcribeToRna(dnaSequence);
    }

    /**
     * Static Method fromFile. Reads the file content as a String using the Method in FileUnits.
     * Validates the String using DNAUtils.
     * If valid, creating a new DNAAnalyzer instance and logs the DNA-Sequence.
     * If invalid, log Error Message "Invalid Sequence" and throws IllegalArgumentException.
     *
     * @param filePath is selected by User and used as argument.
     * @return new DNAAnalyzer with Sequence out of chosen file.
     * @throws IOException IllegalArgumentException in case of failing validation through DNAUtils.
     */
    public static DNAAnalyzer fromFile(String filePath) throws IOException {
        String sequence = FileUtils.readFileAsString(filePath);
        if (DNAUtils.isValidDNA(sequence)) {
            logger.info("DNA sequence: " + sequence);
            return new DNAAnalyzer(sequence);
        } else {
            logger.log(Level.SEVERE, "Invalid DNA sequence: " + sequence);
            throw new IllegalArgumentException("Invalid DNA sequence your selected file! ");
        }
    }

    /**
     * Looking up the position of a codon, given by user.
     *
     * @param codon User Input.
     * @return Position of codon.
     */
    public String findCodonPosition(String codon) {
        return SequenceFinder.findCodonPosition(dnaSequence, codon);
    }

    /**
     * Transcribing DNA into RNA from Start codon on.
     *
     * @return RNA-Sequence coding for proteins.
     */
    public String transcribeToRnaFromStartCodon() {
        return DNATranscriber.transcribeToRna(dnaSequence);
    }

    /**
     * Translating RNA into Proteins.
     *
     * @return Sequence of Proteins.
     */
    public String translateToProtein() {
        return RNATranslator.translateToProtein(rnaSequence);
    }

    /**
     * Getter for DNASequence.
     *
     * @return DNA-Sequence.
     */
    public String getDnaSequence() {
        return dnaSequence;
    }
}
