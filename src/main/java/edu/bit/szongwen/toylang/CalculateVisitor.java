package edu.bit.szongwen.toylang;

import edu.bit.szongwen.toylang.ToyParser.AddMinusContext;
import edu.bit.szongwen.toylang.ToyParser.MinuxContext;
import edu.bit.szongwen.toylang.ToyParser.MulDivContext;
import edu.bit.szongwen.toylang.ToyParser.NumContext;
import edu.bit.szongwen.toylang.ToyParser.ParensContext;
import edu.bit.szongwen.toylang.ToyParser.PercentContext;
import edu.bit.szongwen.toylang.ToyParser.PrintContext;

public class CalculateVisitor extends ToyParserBaseVisitor<Double> {

    @Override
    public Double visitAddMinus(AddMinusContext ctx) {
        Double left = visit(ctx.expression(0));
        Double right = visit(ctx.expression(1));
        if (ctx.op.getType() == ToyParser.PLUS) {
            return left + right;
        } else {
            return left - right;
        }
    }

    @Override
    public Double visitMinux(MinuxContext ctx) {
        return -visit(ctx.expression());
    }

    @Override
    public Double visitMulDiv(MulDivContext ctx) {
        Double left = visit(ctx.expression(0));
        Double right = visit(ctx.expression(1));
        if (ctx.op.getType() == ToyParser.ASTERISK) {
            return left * right;
        } else {
            return left / right;
        }
    }

    @Override
    public Double visitNum(NumContext ctx) {
        return Double.parseDouble(ctx.NUM().getText());
    }

    @Override
    public Double visitParens(ParensContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public Double visitPrint(PrintContext ctx) {
        Double value = visit(ctx.expression());
        System.out.println(value);
        return 0D;
    }

    @Override
    public Double visitPercent(PercentContext ctx) {
        return visit(ctx.expression()) / 100;
    }
}