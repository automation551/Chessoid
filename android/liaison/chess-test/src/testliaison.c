/*
 * testliaison.c
 *
 *  Created on: Oct 28, 2010
 *      Author: troy
 */

#include <stdio.h>
#include <time.h>
#include "common.h"

void test_init_engine();
void test_show_board();
void test_validate_move();
void test_input_cmd_chessoid();

int main()
{
	printf("chess-test: starting chess engine test...\n");
	test_init_engine();
	test_show_board();
	test_validate_move();
	test_input_cmd_chessoid();
	printf("chess-test: chess engine test complete.\n");
	return 0;
}

void test_init_engine()
{
	printf("chess-test: initializing engine...\n");

// 	this stuff needs to run outside of (before) the Initialize command.
//	in the liaison's initializer, we will run this and then call Initialize().
//	it's from main.c's main() originally.

	/* initialize control flags */
	flags = ULL(0);

	/* output for thinking */
	ofp = stdout;

	Initialize();
	printf("chess-test: engine initialization complete.\n");
}

void test_show_board()
{
	printf("chess-test: testing show chess board...\n");
	ShowBoard();
	printf("chess-test: test show chess board complete.\n");
}

void test_validate_move()
{
	printf("chess-test: testing validate move (a5)...\n");
	leaf *result;
	result = ValidateMove("a5");	// invalid move returns null
	if (NULL != result)
		printf("chess-test: result was: %d\n", result->move);
	else
		printf("chess-test: result was NULL\n");
}

void test_input_cmd_chessoid()
{
	printf("chess-test: testing input engine command...\n");
	InputCmdChessoid("help");
	InputCmdChessoid("a3");
	printf("chess-test: done testing input engine command.\n");
}
