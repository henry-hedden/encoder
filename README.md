CSC-253 Final Project -- Encoder/Decoder
========================================

*Henry Hedden*

Description
-----------

The program prompts the user to enter text, and select from one of several
different codes to use, via a GUI. The user can then choose to either encode
plaintext, or decode encoded text.

Classes
-------

* EncoderGUI -- driver class
  - EncoderGUI -- constructor
  - void main -- main method
  - ClickHandler -- private class for event handling
   - actionPerformed -- responds to button clicks
* EncoderTerminal -- command line driver class used for testing
  - void main -- main method
* Encoder -- class containing encode/decode methods
  - String encode(String plaintext, Code c) -- static method to encode text
  - String decode(String codedText, Code c) -- static method to decode text
  - String encodeCaesar -- Uses the Caesar cipher to encode text.
  - String decodeCaesar -- Decode text encoded in the Caesar cipher
  - String encodePolybius -- Encode text using the Polybius cipher (Unsupported)
  - String encodeTrimethius -- Encode using Trimethius, a simple polyalphabetic
   cipher which iterates over a series of alphabets.
  - String encodeVigenere -- Encode text using Vigenère, a simple polyaphabetic
   cipher which uses a word as a key
  - String decodePolybius -- Encode text using the Polybius cipher (Unsupported)
  - String decodeTrimethius -- Decode text encoded in the Trimethius cipher
  - String decodeVigenere -- Decode text encoded in the Vigenère cipher
* Code -- enum for different code options
  - CAESAR -- Caesar cipher
  - POLYBIUS -- Polybius cipher
  - TRIMETHIUS -- Trimethius cipher
  - VIGENERE -- Vigenère cipher

Process
-------

1. The main method creates a window with two text areas, a combo box,
   and two buttons.
2. To encode text, the user enters text in the top text area, selects a cipher
   from the combo box, and clicks the "encode" button.
3. The click event handler reads the value from the combo box to determine which
   cipher to use, and passes the text from the input text area to the
   appropriate encode method in the Encoder class. The encoded text is displayed
   in the second text area.
4. To *decode* text, the user enters encoded text in the input text area,
   selects the appropriate cipher from the combo box, and clicks the "decode"
   button.
5. The click event handler then reads the value from the input text area, and
   passes the text to the appropriate *decode* method in the Encoder class.
6. If the user attempts to encode or decode text using the Vigenère cipher, they
   will be prompted by a JOptionPane to enter a key word.
7. If a user action results in an error, the user will be notified with an error
   message displayed by a JOptionPane.
