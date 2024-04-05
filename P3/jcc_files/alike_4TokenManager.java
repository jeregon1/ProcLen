/* alike_4TokenManager.java */
/* Generated By:JavaCC: Do not edit this line. alike_4TokenManager.java */
package traductor;
import lib.symbolTable.*;
import lib.symbolTable.exceptions.*;
import lib.tools.SemanticFunctions.SemanticFunctions;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.LinkedHashMap;

/** Token Manager. */
@SuppressWarnings ("unused")
public class alike_4TokenManager implements alike_4Constants {

  /** Debug output. */
  public static  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public static  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private static final int jjStopStringLiteralDfa_0(int pos, long active0){
   switch (pos)
   {
      case 0:
         if ((active0 & 0x100000000000000L) != 0L)
            return 0;
         if ((active0 & 0x801c3fffffbe000L) != 0L)
         {
            jjmatchedKind = 60;
            return 13;
         }
         return -1;
      case 1:
         if ((active0 & 0x80143ffefd9e000L) != 0L)
         {
            jjmatchedKind = 60;
            jjmatchedPos = 1;
            return 13;
         }
         if ((active0 & 0x800010220000L) != 0L)
            return 13;
         return -1;
      case 2:
         if ((active0 & 0x801400748000000L) != 0L)
            return 13;
         if ((active0 & 0x3f8a7d9e000L) != 0L)
         {
            if (jjmatchedPos != 2)
            {
               jjmatchedKind = 60;
               jjmatchedPos = 2;
            }
            return 13;
         }
         return -1;
      case 3:
         if ((active0 & 0x1c001500000L) != 0L)
            return 13;
         if ((active0 & 0x23aa689e000L) != 0L)
         {
            jjmatchedKind = 60;
            jjmatchedPos = 3;
            return 13;
         }
         return -1;
      case 4:
         if ((active0 & 0x3a8600e000L) != 0L)
         {
            jjmatchedKind = 60;
            jjmatchedPos = 4;
            return 13;
         }
         if ((active0 & 0x20020890000L) != 0L)
            return 13;
         return -1;
      case 5:
         if ((active0 & 0x3a0600e000L) != 0L)
         {
            jjmatchedKind = 60;
            jjmatchedPos = 5;
            return 13;
         }
         if ((active0 & 0x80000000L) != 0L)
            return 13;
         return -1;
      case 6:
         if ((active0 & 0xa000L) != 0L)
            return 13;
         if ((active0 & 0x3a06004000L) != 0L)
         {
            jjmatchedKind = 60;
            jjmatchedPos = 6;
            return 13;
         }
         return -1;
      case 7:
         if ((active0 & 0x802004000L) != 0L)
         {
            jjmatchedKind = 60;
            jjmatchedPos = 7;
            return 13;
         }
         if ((active0 & 0x3204000000L) != 0L)
            return 13;
         return -1;
      default :
         return -1;
   }
}
private static final int jjStartNfa_0(int pos, long active0){
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
}
static private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
static private int jjMoveStringLiteralDfa0_0(){
   switch(curChar)
   {
      case 40:
         return jjStopAtPos(0, 11);
      case 41:
         return jjStopAtPos(0, 12);
      case 42:
         return jjStopAtPos(0, 57);
      case 43:
         return jjStopAtPos(0, 55);
      case 44:
         return jjStopAtPos(0, 10);
      case 45:
         return jjStartNfaWithStates_0(0, 56, 0);
      case 46:
         return jjMoveStringLiteralDfa1_0(0x40000L);
      case 47:
         jjmatchedKind = 58;
         return jjMoveStringLiteralDfa1_0(0x4000000000000L);
      case 58:
         jjmatchedKind = 9;
         return jjMoveStringLiteralDfa1_0(0x200000000000L);
      case 59:
         return jjStopAtPos(0, 8);
      case 60:
         jjmatchedKind = 51;
         return jjMoveStringLiteralDfa1_0(0x10000000000000L);
      case 61:
         return jjStopAtPos(0, 49);
      case 62:
         jjmatchedKind = 53;
         return jjMoveStringLiteralDfa1_0(0x40000000000000L);
      case 65:
      case 97:
         return jjMoveStringLiteralDfa1_0(0x400000010000L);
      case 66:
      case 98:
         return jjMoveStringLiteralDfa1_0(0x20008000L);
      case 67:
      case 99:
         return jjMoveStringLiteralDfa1_0(0x2000004000L);
      case 69:
      case 101:
         return jjMoveStringLiteralDfa1_0(0x4041800000L);
      case 70:
      case 102:
         return jjMoveStringLiteralDfa1_0(0x20004000000L);
      case 71:
      case 103:
         return jjMoveStringLiteralDfa1_0(0x400000000L);
      case 73:
      case 105:
         return jjMoveStringLiteralDfa1_0(0x1010202000L);
      case 76:
      case 108:
         return jjMoveStringLiteralDfa1_0(0x100000L);
      case 77:
      case 109:
         return jjMoveStringLiteralDfa1_0(0x800000000000000L);
      case 78:
      case 110:
         return jjMoveStringLiteralDfa1_0(0x1008000000000L);
      case 79:
      case 111:
         return jjMoveStringLiteralDfa1_0(0x800000020000L);
      case 80:
      case 112:
         return jjMoveStringLiteralDfa1_0(0x302000000L);
      case 82:
      case 114:
         return jjMoveStringLiteralDfa1_0(0x88000000L);
      case 83:
      case 115:
         return jjMoveStringLiteralDfa1_0(0x800000000L);
      case 84:
      case 116:
         return jjMoveStringLiteralDfa1_0(0x10000400000L);
      case 87:
      case 119:
         return jjMoveStringLiteralDfa1_0(0x80000L);
      default :
         return jjMoveNfa_0(2, 0);
   }
}
static private int jjMoveStringLiteralDfa1_0(long active0){
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0);
      return 1;
   }
   switch(curChar)
   {
      case 46:
         if ((active0 & 0x40000L) != 0L)
            return jjStopAtPos(1, 18);
         break;
      case 61:
         if ((active0 & 0x200000000000L) != 0L)
            return jjStopAtPos(1, 45);
         else if ((active0 & 0x4000000000000L) != 0L)
            return jjStopAtPos(1, 50);
         else if ((active0 & 0x10000000000000L) != 0L)
            return jjStopAtPos(1, 52);
         else if ((active0 & 0x40000000000000L) != 0L)
            return jjStopAtPos(1, 54);
         break;
      case 65:
      case 97:
         return jjMoveStringLiteralDfa2_0(active0, 0x20000000000L);
      case 69:
      case 101:
         return jjMoveStringLiteralDfa2_0(active0, 0x4a8000000L);
      case 70:
      case 102:
         if ((active0 & 0x20000L) != 0L)
            return jjStartNfaWithStates_0(1, 17, 13);
         else if ((active0 & 0x200000L) != 0L)
            return jjStartNfaWithStates_0(1, 21, 13);
         break;
      case 72:
      case 104:
         return jjMoveStringLiteralDfa2_0(active0, 0x2000484000L);
      case 75:
      case 107:
         return jjMoveStringLiteralDfa2_0(active0, 0x800000000L);
      case 76:
      case 108:
         return jjMoveStringLiteralDfa2_0(active0, 0x1800000L);
      case 78:
      case 110:
         return jjMoveStringLiteralDfa2_0(active0, 0x401040002000L);
      case 79:
      case 111:
         return jjMoveStringLiteralDfa2_0(active0, 0x801000000108000L);
      case 82:
      case 114:
         if ((active0 & 0x800000000000L) != 0L)
            return jjStartNfaWithStates_0(1, 47, 13);
         return jjMoveStringLiteralDfa2_0(active0, 0x10002010000L);
      case 83:
      case 115:
         if ((active0 & 0x10000000L) != 0L)
            return jjStartNfaWithStates_0(1, 28, 13);
         break;
      case 85:
      case 117:
         return jjMoveStringLiteralDfa2_0(active0, 0x8304000000L);
      case 88:
      case 120:
         return jjMoveStringLiteralDfa2_0(active0, 0x4000000000L);
      default :
         break;
   }
   return jjStartNfa_0(0, active0);
}
static private int jjMoveStringLiteralDfa2_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(0, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0);
      return 2;
   }
   switch(curChar)
   {
      case 65:
      case 97:
         return jjMoveStringLiteralDfa3_0(active0, 0x2000004000L);
      case 68:
      case 100:
         if ((active0 & 0x40000000L) != 0L)
            return jjStartNfaWithStates_0(2, 30, 13);
         else if ((active0 & 0x400000000000L) != 0L)
            return jjStartNfaWithStates_0(2, 46, 13);
         else if ((active0 & 0x800000000000000L) != 0L)
            return jjStartNfaWithStates_0(2, 59, 13);
         break;
      case 69:
      case 101:
         return jjMoveStringLiteralDfa3_0(active0, 0x400000L);
      case 70:
      case 102:
         if ((active0 & 0x8000000L) != 0L)
            return jjStartNfaWithStates_0(2, 27, 13);
         break;
      case 71:
      case 103:
         return jjMoveStringLiteralDfa3_0(active0, 0x20000000L);
      case 73:
      case 105:
         return jjMoveStringLiteralDfa3_0(active0, 0x4800080000L);
      case 76:
      case 108:
         return jjMoveStringLiteralDfa3_0(active0, 0x28000000000L);
      case 78:
      case 110:
         return jjMoveStringLiteralDfa3_0(active0, 0x4000000L);
      case 79:
      case 111:
         return jjMoveStringLiteralDfa3_0(active0, 0x2108000L);
      case 82:
      case 114:
         return jjMoveStringLiteralDfa3_0(active0, 0x10000L);
      case 83:
      case 115:
         return jjMoveStringLiteralDfa3_0(active0, 0x1800000L);
      case 84:
      case 116:
         if ((active0 & 0x100000000L) != 0L)
         {
            jjmatchedKind = 32;
            jjmatchedPos = 2;
         }
         else if ((active0 & 0x400000000L) != 0L)
            return jjStartNfaWithStates_0(2, 34, 13);
         else if ((active0 & 0x1000000000000L) != 0L)
            return jjStartNfaWithStates_0(2, 48, 13);
         return jjMoveStringLiteralDfa3_0(active0, 0x1280002000L);
      case 85:
      case 117:
         return jjMoveStringLiteralDfa3_0(active0, 0x10000000000L);
      default :
         break;
   }
   return jjStartNfa_0(1, active0);
}
static private int jjMoveStringLiteralDfa3_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(1, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0);
      return 3;
   }
   switch(curChar)
   {
      case 50:
         return jjMoveStringLiteralDfa4_0(active0, 0x1000000000L);
      case 95:
         return jjMoveStringLiteralDfa4_0(active0, 0x200000000L);
      case 65:
      case 97:
         return jjMoveStringLiteralDfa4_0(active0, 0x10000L);
      case 67:
      case 99:
         return jjMoveStringLiteralDfa4_0(active0, 0x6000000L);
      case 69:
      case 101:
         if ((active0 & 0x1000000L) != 0L)
            return jjStartNfaWithStates_0(3, 24, 13);
         else if ((active0 & 0x10000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 40, 13);
         return jjMoveStringLiteralDfa4_0(active0, 0x2000L);
      case 73:
      case 105:
         return jjMoveStringLiteralDfa4_0(active0, 0x20800000L);
      case 76:
      case 108:
         if ((active0 & 0x8000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 39, 13);
         return jjMoveStringLiteralDfa4_0(active0, 0x88000L);
      case 78:
      case 110:
         if ((active0 & 0x400000L) != 0L)
            return jjStartNfaWithStates_0(3, 22, 13);
         break;
      case 80:
      case 112:
         if ((active0 & 0x100000L) != 0L)
            return jjStartNfaWithStates_0(3, 20, 13);
         return jjMoveStringLiteralDfa4_0(active0, 0x800000000L);
      case 82:
      case 114:
         return jjMoveStringLiteralDfa4_0(active0, 0x2000004000L);
      case 83:
      case 115:
         return jjMoveStringLiteralDfa4_0(active0, 0x20000000000L);
      case 84:
      case 116:
         if ((active0 & 0x4000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 38, 13);
         break;
      case 85:
      case 117:
         return jjMoveStringLiteralDfa4_0(active0, 0x80000000L);
      default :
         break;
   }
   return jjStartNfa_0(2, active0);
}
static private int jjMoveStringLiteralDfa4_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(2, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0);
      return 4;
   }
   switch(curChar)
   {
      case 50:
         return jjMoveStringLiteralDfa5_0(active0, 0x2000000000L);
      case 95:
         return jjMoveStringLiteralDfa5_0(active0, 0x800000000L);
      case 65:
      case 97:
         return jjMoveStringLiteralDfa5_0(active0, 0x4000L);
      case 67:
      case 99:
         return jjMoveStringLiteralDfa5_0(active0, 0x1000000000L);
      case 69:
      case 101:
         if ((active0 & 0x80000L) != 0L)
            return jjStartNfaWithStates_0(4, 19, 13);
         else if ((active0 & 0x20000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 41, 13);
         return jjMoveStringLiteralDfa5_0(active0, 0x2008000L);
      case 70:
      case 102:
         if ((active0 & 0x800000L) != 0L)
            return jjStartNfaWithStates_0(4, 23, 13);
         break;
      case 71:
      case 103:
         return jjMoveStringLiteralDfa5_0(active0, 0x2000L);
      case 76:
      case 108:
         return jjMoveStringLiteralDfa5_0(active0, 0x200000000L);
      case 78:
      case 110:
         if ((active0 & 0x20000000L) != 0L)
            return jjStartNfaWithStates_0(4, 29, 13);
         break;
      case 82:
      case 114:
         return jjMoveStringLiteralDfa5_0(active0, 0x80000000L);
      case 84:
      case 116:
         return jjMoveStringLiteralDfa5_0(active0, 0x4000000L);
      case 89:
      case 121:
         if ((active0 & 0x10000L) != 0L)
            return jjStartNfaWithStates_0(4, 16, 13);
         break;
      default :
         break;
   }
   return jjStartNfa_0(3, active0);
}
static private int jjMoveStringLiteralDfa5_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(3, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(4, active0);
      return 5;
   }
   switch(curChar)
   {
      case 65:
      case 97:
         return jjMoveStringLiteralDfa6_0(active0, 0x8000L);
      case 67:
      case 99:
         return jjMoveStringLiteralDfa6_0(active0, 0x4000L);
      case 68:
      case 100:
         return jjMoveStringLiteralDfa6_0(active0, 0x2000000L);
      case 69:
      case 101:
         return jjMoveStringLiteralDfa6_0(active0, 0x2000L);
      case 72:
      case 104:
         return jjMoveStringLiteralDfa6_0(active0, 0x1000000000L);
      case 73:
      case 105:
         return jjMoveStringLiteralDfa6_0(active0, 0x2204000000L);
      case 76:
      case 108:
         return jjMoveStringLiteralDfa6_0(active0, 0x800000000L);
      case 78:
      case 110:
         if ((active0 & 0x80000000L) != 0L)
            return jjStartNfaWithStates_0(5, 31, 13);
         break;
      default :
         break;
   }
   return jjStartNfa_0(4, active0);
}
static private int jjMoveStringLiteralDfa6_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(4, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(5, active0);
      return 6;
   }
   switch(curChar)
   {
      case 65:
      case 97:
         return jjMoveStringLiteralDfa7_0(active0, 0x1000000000L);
      case 73:
      case 105:
         return jjMoveStringLiteralDfa7_0(active0, 0x800000000L);
      case 78:
      case 110:
         if ((active0 & 0x8000L) != 0L)
            return jjStartNfaWithStates_0(6, 15, 13);
         return jjMoveStringLiteralDfa7_0(active0, 0x2200000000L);
      case 79:
      case 111:
         return jjMoveStringLiteralDfa7_0(active0, 0x4000000L);
      case 82:
      case 114:
         if ((active0 & 0x2000L) != 0L)
            return jjStartNfaWithStates_0(6, 13, 13);
         break;
      case 84:
      case 116:
         return jjMoveStringLiteralDfa7_0(active0, 0x4000L);
      case 85:
      case 117:
         return jjMoveStringLiteralDfa7_0(active0, 0x2000000L);
      default :
         break;
   }
   return jjStartNfa_0(5, active0);
}
static private int jjMoveStringLiteralDfa7_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(5, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(6, active0);
      return 7;
   }
   switch(curChar)
   {
      case 69:
      case 101:
         if ((active0 & 0x200000000L) != 0L)
            return jjStartNfaWithStates_0(7, 33, 13);
         return jjMoveStringLiteralDfa8_0(active0, 0x4000L);
      case 78:
      case 110:
         if ((active0 & 0x4000000L) != 0L)
            return jjStartNfaWithStates_0(7, 26, 13);
         return jjMoveStringLiteralDfa8_0(active0, 0x800000000L);
      case 82:
      case 114:
         if ((active0 & 0x1000000000L) != 0L)
            return jjStartNfaWithStates_0(7, 36, 13);
         return jjMoveStringLiteralDfa8_0(active0, 0x2000000L);
      case 84:
      case 116:
         if ((active0 & 0x2000000000L) != 0L)
            return jjStartNfaWithStates_0(7, 37, 13);
         break;
      default :
         break;
   }
   return jjStartNfa_0(6, active0);
}
static private int jjMoveStringLiteralDfa8_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(6, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(7, active0);
      return 8;
   }
   switch(curChar)
   {
      case 69:
      case 101:
         if ((active0 & 0x2000000L) != 0L)
            return jjStartNfaWithStates_0(8, 25, 13);
         else if ((active0 & 0x800000000L) != 0L)
            return jjStartNfaWithStates_0(8, 35, 13);
         break;
      case 82:
      case 114:
         if ((active0 & 0x4000L) != 0L)
            return jjStartNfaWithStates_0(8, 14, 13);
         break;
      default :
         break;
   }
   return jjStartNfa_0(7, active0);
}
static private int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
static final long[] jjbitVec0 = {
   0xfffffffffffffffeL, 0xffffffffffffffffL, 0xffffffffffffffffL, 0xffffffffffffffffL
};
static final long[] jjbitVec2 = {
   0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
};
static private int jjMoveNfa_0(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 14;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 2:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 42)
                        kind = 42;
                     { jjCheckNAdd(3); }
                  }
                  else if (curChar == 34)
                     { jjCheckNAddStates(0, 2); }
                  else if (curChar == 39)
                     jjstateSet[jjnewStateCnt++] = 5;
                  else if (curChar == 45)
                     jjstateSet[jjnewStateCnt++] = 0;
                  break;
               case 0:
                  if (curChar != 45)
                     break;
                  if (kind > 5)
                     kind = 5;
                  { jjCheckNAdd(1); }
                  break;
               case 1:
                  if ((0xffffffffffffdbffL & l) == 0L)
                     break;
                  if (kind > 5)
                     kind = 5;
                  { jjCheckNAdd(1); }
                  break;
               case 3:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 42)
                     kind = 42;
                  { jjCheckNAdd(3); }
                  break;
               case 4:
                  if (curChar == 39)
                     jjstateSet[jjnewStateCnt++] = 5;
                  break;
               case 5:
                  jjstateSet[jjnewStateCnt++] = 6;
                  break;
               case 6:
                  if (curChar == 39 && kind > 43)
                     kind = 43;
                  break;
               case 7:
               case 9:
                  if (curChar == 34)
                     { jjCheckNAddStates(0, 2); }
                  break;
               case 8:
                  if ((0xfffffffbffffffffL & l) != 0L)
                     { jjCheckNAddStates(0, 2); }
                  break;
               case 10:
                  if (curChar == 34)
                     jjstateSet[jjnewStateCnt++] = 9;
                  break;
               case 11:
                  if (curChar == 34 && kind > 44)
                     kind = 44;
                  break;
               case 13:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 60)
                     kind = 60;
                  jjstateSet[jjnewStateCnt++] = 13;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 2:
               case 13:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 60)
                     kind = 60;
                  { jjCheckNAdd(13); }
                  break;
               case 1:
                  if (kind > 5)
                     kind = 5;
                  jjstateSet[jjnewStateCnt++] = 1;
                  break;
               case 5:
                  jjstateSet[jjnewStateCnt++] = 6;
                  break;
               case 8:
                  { jjAddStates(0, 2); }
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int hiByte = (curChar >> 8);
         int i1 = hiByte >> 6;
         long l1 = 1L << (hiByte & 077);
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 1:
                  if (!jjCanMove_0(hiByte, i1, i2, l1, l2))
                     break;
                  if (kind > 5)
                     kind = 5;
                  jjstateSet[jjnewStateCnt++] = 1;
                  break;
               case 5:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjstateSet[jjnewStateCnt++] = 6;
                  break;
               case 8:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     { jjAddStates(0, 2); }
                  break;
               default : if (i1 == 0 || l1 == 0 || i2 == 0 ||  l2 == 0) break; else break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 14 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}

/** Token literal values. */
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, null, null, null, "\73", "\72", "\54", "\50", 
"\51", null, null, null, null, null, "\56\56", null, null, null, null, null, null, 
null, null, null, null, null, null, null, null, null, null, null, null, null, null, 
null, null, null, null, null, null, "\72\75", null, null, null, "\75", "\57\75", 
"\74", "\74\75", "\76", "\76\75", "\53", "\55", "\52", "\57", null, null, null, };
static protected Token jjFillToken()
{
   final Token t;
   final String curTokenImage;
   final int beginLine;
   final int endLine;
   final int beginColumn;
   final int endColumn;
   String im = jjstrLiteralImages[jjmatchedKind];
   curTokenImage = (im == null) ? input_stream.GetImage() : im;
   beginLine = input_stream.getBeginLine();
   beginColumn = input_stream.getBeginColumn();
   endLine = input_stream.getEndLine();
   endColumn = input_stream.getEndColumn();
   t = Token.newToken(jjmatchedKind, curTokenImage);

   t.beginLine = beginLine;
   t.endLine = endLine;
   t.beginColumn = beginColumn;
   t.endColumn = endColumn;

   return t;
}
static final int[] jjnextStates = {
   8, 10, 11, 
};
private static final boolean jjCanMove_0(int hiByte, int i1, int i2, long l1, long l2)
{
   switch(hiByte)
   {
      case 0:
         return ((jjbitVec2[i2] & l2) != 0L);
      default :
         if ((jjbitVec0[i1] & l1) != 0L)
            return true;
         return false;
   }
}

static int curLexState = 0;
static int defaultLexState = 0;
static int jjnewStateCnt;
static int jjround;
static int jjmatchedPos;
static int jjmatchedKind;

/** Get the next Token. */
public static Token getNextToken() 
{
  Token specialToken = null;
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {
   try
   {
      curChar = input_stream.BeginToken();
   }
   catch(Exception e)
   {
      jjmatchedKind = 0;
      jjmatchedPos = -1;
      matchedToken = jjFillToken();
      matchedToken.specialToken = specialToken;
      return matchedToken;
   }
   image = jjimage;
   image.setLength(0);
   jjimageLen = 0;

   try { input_stream.backup(0);
      while (curChar <= 32 && (0x100002600L & (1L << curChar)) != 0L)
         curChar = input_stream.BeginToken();
   }
   catch (java.io.IOException e1) { continue EOFLoop; }
   jjmatchedKind = 0x7fffffff;
   jjmatchedPos = 0;
   curPos = jjMoveStringLiteralDfa0_0();
   if (jjmatchedPos == 0 && jjmatchedKind > 61)
   {
      jjmatchedKind = 61;
   }
   if (jjmatchedKind != 0x7fffffff)
   {
      if (jjmatchedPos + 1 < curPos)
         input_stream.backup(curPos - jjmatchedPos - 1);
      if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
      {
         matchedToken = jjFillToken();
         matchedToken.specialToken = specialToken;
         TokenLexicalActions(matchedToken);
         return matchedToken;
      }
      else
      {
         if ((jjtoSpecial[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
         {
            matchedToken = jjFillToken();
            if (specialToken == null)
               specialToken = matchedToken;
            else
            {
               matchedToken.specialToken = specialToken;
               specialToken = (specialToken.next = matchedToken);
            }
            SkipLexicalActions(matchedToken);
         }
         else
            SkipLexicalActions(null);
         continue EOFLoop;
      }
   }
   int error_line = input_stream.getEndLine();
   int error_column = input_stream.getEndColumn();
   String error_after = null;
   boolean EOFSeen = false;
   try { input_stream.readChar(); input_stream.backup(1); }
   catch (java.io.IOException e1) {
      EOFSeen = true;
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
      if (curChar == '\n' || curChar == '\r') {
         error_line++;
         error_column = 0;
      }
      else
         error_column++;
   }
   if (!EOFSeen) {
      input_stream.backup(1);
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
   }
   throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

static void SkipLexicalActions(Token matchedToken)
{
   switch(jjmatchedKind)
   {
      case 61 :
         image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
                        System.err.println("----------------------------------------");
                        System.err.println(TokenMgrError.LexicalErr(matchedToken, "Car\u00e1cter extra\u00f1o: '" + matchedToken.image + "'. Reemplazo por espacio"));
                        matchedToken.image = " ";
         break;
      default :
         break;
   }
}
static void MoreLexicalActions()
{
   jjimageLen += (lengthOfMatch = jjmatchedPos + 1);
   switch(jjmatchedKind)
   {
      default :
         break;
   }
}
static void TokenLexicalActions(Token matchedToken)
{
   switch(jjmatchedKind)
   {
      case 44 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
                // Sustituir las comillas dobles por una comilla simple
                String str = matchedToken.image;
                str = str.substring(1, str.length() - 1); // Eliminar las comillas dobles de los extremos
                matchedToken.image = str.replace("\"\"", "\"");
         break;
      default :
         break;
   }
}
static private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
static private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
static private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

static private void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}

    /** Constructor. */
    public alike_4TokenManager(SimpleCharStream stream){

      if (input_stream != null)
        throw new TokenMgrError("ERROR: Second call to constructor of static lexer. You must use ReInit() to initialize the static variables.", TokenMgrError.STATIC_LEXER_ERROR);

    input_stream = stream;
  }

  /** Constructor. */
  public alike_4TokenManager (SimpleCharStream stream, int lexState){
    ReInit(stream);
    SwitchTo(lexState);
  }

  /** Reinitialise parser. */
  
  static public void ReInit(SimpleCharStream stream)
  {


    jjmatchedPos =
    jjnewStateCnt =
    0;
    curLexState = defaultLexState;
    input_stream = stream;
    ReInitRounds();
  }

  static private void ReInitRounds()
  {
    int i;
    jjround = 0x80000001;
    for (i = 14; i-- > 0;)
      jjrounds[i] = 0x80000000;
  }

  /** Reinitialise parser. */
  static public void ReInit(SimpleCharStream stream, int lexState)
  
  {
    ReInit(stream);
    SwitchTo(lexState);
  }

  /** Switch to specified lex state. */
  public static void SwitchTo(int lexState)
  {
    if (lexState >= 1 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
    else
      curLexState = lexState;
  }


/** Lexer state names. */
public static final String[] lexStateNames = {
   "DEFAULT",
};

/** Lex State array. */
public static final int[] jjnewLexState = {
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
};
static final long[] jjtoToken = {
   0x1fffffffffffff01L, 
};
static final long[] jjtoSkip = {
   0x200000000000003eL, 
};
static final long[] jjtoSpecial = {
   0x2000000000000000L, 
};
static final long[] jjtoMore = {
   0x0L, 
};
    static protected SimpleCharStream  input_stream;

    static private final int[] jjrounds = new int[14];
    static private final int[] jjstateSet = new int[2 * 14];
    private static final StringBuilder jjimage = new StringBuilder();
    private static StringBuilder image = jjimage;
    private static int jjimageLen;
    private static int lengthOfMatch;
    static protected int curChar;
}
