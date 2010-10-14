package edu.utd.chess.game;

import java.util.ArrayList;
import java.util.Collection;

import edu.utd.chess.board.ChessBoard;
import edu.utd.chess.board.ChessCoords;
import edu.utd.chess.exceptions.ChessPieceNotFoundException;
import edu.utd.chess.exceptions.CoordsOccupiedException;
import edu.utd.chess.exceptions.HomicideException;
import edu.utd.chess.exceptions.IllegalMoveException;
import edu.utd.chess.exceptions.InvalidCoordsException;
import edu.utd.chess.exceptions.SuicideException;
import edu.utd.chess.exceptions.CoreChessGameException;
import edu.utd.chess.pieces.Bishop;
import edu.utd.chess.pieces.ChessPiece;
import edu.utd.chess.pieces.King;
import edu.utd.chess.pieces.Knight;
import edu.utd.chess.pieces.Pawn;
import edu.utd.chess.pieces.Queen;
import edu.utd.chess.pieces.Rook;

/**
 * Singleton
 * This will be the "main" class for the game.
 * You ask the ChessGame for the ChessBoard, the current
 * state of the game, whose turn it is to go next, etc.
 */
public class ChessGame {
	ChessBoard chessBoard;
	
	public static final ChessGame INSTANCE = new ChessGame();
	
	private ChessGame() {
	    initialize();
	}
	
	public ChessGame(ChessBoard chessBoard) {
		this.chessBoard = chessBoard;
	}
	
	/**
	 * (re-) initialize the chess game, i.e. start a new game.
	 * Resets the chessboard to an initial state.
	 */
	public void initialize() {
		chessBoard = new ChessBoard(createDefaultChessSet());
		
	}
	
	/**
	 * Get the ChessBoard for the current game
	 */
	public ChessBoard getChessBoard() {
		return this.chessBoard;
	}
	
	/**
	 * Creates a set of chess pieces (i.e. an ArrayList) in the standard 
	 * 32 piece configuration (16 black, 16 white).
	 * @return <code>List</code> of <code>ChessPiece</code>s
	 */
	public Collection<ChessPiece> createDefaultChessSet() {
		ArrayList<ChessPiece> pieces = new ArrayList<ChessPiece>(32);
		
		//black pawns
		byte ascii[] = {65};
		for (int i=0; i < 8; i++) {
			//A7 - H7
			ChessCoords coords = new ChessCoords(new String(ascii), 7);
			ascii[0] = (byte) (ascii[0] + (byte) 1);
			pieces.add(new Pawn(ChessPiece.BLACK, coords));
		}
		
		//the rest
		ChessCoords a8 = new ChessCoords("A", 8);
		pieces.add(new Rook(ChessPiece.BLACK, a8));
		
		ChessCoords b8 = new ChessCoords("B", 8);
		pieces.add(new Knight(ChessPiece.BLACK, b8));
		
		ChessCoords c8 = new ChessCoords("C", 8);
		pieces.add(new Bishop(ChessPiece.BLACK, c8));
		
		ChessCoords d8 = new ChessCoords("D", 8);
		pieces.add(new Queen(ChessPiece.BLACK, d8));
		
		ChessCoords e8 = new ChessCoords("E", 8);
		pieces.add(new King(ChessPiece.BLACK, e8));
		
		ChessCoords f8 = new ChessCoords("F", 8);
		pieces.add(new Bishop(ChessPiece.BLACK, f8));
		
		ChessCoords g8 = new ChessCoords("G", 8);
		pieces.add(new Knight(ChessPiece.BLACK, g8));
		
		ChessCoords h8 = new ChessCoords("H", 8);
		pieces.add(new Rook(ChessPiece.BLACK, h8));
		
		//white pawns
		byte ascii2[] = {65};
		for (int i=0; i < 8; i++) {
			//A2 - H2
			ChessCoords coords = new ChessCoords(new String(ascii2), 2);
			ascii2[0] = (byte) (ascii2[0] + (byte) 1);
			pieces.add(new Pawn(ChessPiece.WHITE, coords));
		}
		
		//the rest
		ChessCoords a1 = new ChessCoords("A", 1);
		pieces.add(new Rook(ChessPiece.WHITE, a1));
		
		ChessCoords b1_coords = new ChessCoords("B", 1);
		pieces.add(new Knight(ChessPiece.WHITE, b1_coords));
		
		ChessCoords c1 = new ChessCoords("C", 1);
		pieces.add(new Bishop(ChessPiece.WHITE, c1));
		
		ChessCoords d1 = new ChessCoords("D", 1);
		pieces.add(new Queen(ChessPiece.WHITE, d1));
		
		ChessCoords e1 = new ChessCoords("E", 1);
		pieces.add(new King(ChessPiece.WHITE, e1));
		
		ChessCoords f1 = new ChessCoords("F", 1);
		pieces.add(new Bishop(ChessPiece.WHITE, f1));
		
		ChessCoords g1 = new ChessCoords("G", 1);
		pieces.add(new Knight(ChessPiece.WHITE, g1));
		
		ChessCoords h1 = new ChessCoords("H", 1);
		pieces.add(new Rook(ChessPiece.WHITE, h1));
		
		return pieces;
	}
	
	/**
	 * Perform a capture action.  The attacker tries to capture
	 * the victim, and the ChessBoard associated with this game
	 * will be updated.  It is the responsibility of a caller to perform
	 * validation that this is a legal move, before this method
	 * is called, and to process the appropriate moves for a victorious
	 * attacker afterwards.
	 * @param attacker
	 * @param victim
	 * @throws ChessPieceNotFoundException if one of the pieces doesn't
	 * exist on the ChessBoard
	 * @throws SuicideException if the victim and the attacker are the same piece
	 * @throws HomicideException if both attacker and victim are on the
	 * same side.
	 * @throws CoreChessGameException if something goes horribly wrong
	 */
	public void processCapture(ChessPiece attacker, ChessPiece victim) 
		throws 
			ChessPieceNotFoundException,
			InvalidCoordsException,
			IllegalMoveException,
			SuicideException,
			HomicideException,
			CoreChessGameException
	{
		// validation
		if (null == this.getChessBoard().getChessPieceAt(attacker.location)) {	//TODO: testme!  is this a bug?  what if coords are null?
			throw new ChessPieceNotFoundException("Chess piece does not exist: " + attacker);
		}
		if (null == this.getChessBoard().getChessPieceAt(victim.location)) {
			throw new ChessPieceNotFoundException("Chess piece does not exist: " + victim);
		}
		if (victim == attacker) {
			throw new SuicideException();
		}
		if (attacker.alignment.equals(victim.alignment)) {
			throw new HomicideException();
		}
		
		// kill the victim
		this.getChessBoard().removePiece(victim.location);
		try {
			this.getChessBoard().movePiece(attacker.location, victim.location);
		}
		catch (CoordsOccupiedException e) {
			throw new CoreChessGameException("Victim's coordinates still occupied after capture!");
		}
	}
	
	/**
	 * Attempt to move a piece, if the space it's moving to is occupied, 
	 * attempt to capture the piece.
	 * @param from ChessCoords to move from
	 * @param to ChessCoords to move to
	 * @throws InvalidCoordsException if either 'from' ChessCoords or 'to'
	 * ChessCoords are invalid
	 * @throws IllegalMoveException if the requested move constitutes an illegal move
	 * for the piece
	 * @throws SuicideException if 'from' and 'to' are the same location
	 * @throws HomicideException if the piece at 'from' and 'to' are on the same side
	 * @throws ChessPieceNotFoundException if the 'from' piece does not exist
	 * @throws CoreChessGameException if something goes horribly wrong
	 */
	public void processMove(ChessCoords from, ChessCoords to) 
		throws
			InvalidCoordsException,
			IllegalMoveException,
			SuicideException,
			HomicideException,
			ChessPieceNotFoundException,
			CoreChessGameException
	{
		try {
			getChessBoard().movePiece(from, to);
		}
		catch (CoordsOccupiedException e) {
			ChessPiece attacker = getChessBoard().getChessPieceAt(from);
			ChessPiece victim = getChessBoard().getChessPieceAt(to);
			processCapture(attacker, victim);
		}
	}
}