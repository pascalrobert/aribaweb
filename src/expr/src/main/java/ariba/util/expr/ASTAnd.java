//--------------------------------------------------------------------------
//	Copyright (c) 1998-2004, Drew Davidson and Luke Blanshard
//  All rights reserved.
//
//	Redistribution and use in source and binary forms, with or without
//  modification, are permitted provided that the following conditions are
//  met:
//
//	Redistributions of source code must retain the above copyright notice,
//  this list of conditions and the following disclaimer.
//	Redistributions in binary form must reproduce the above copyright
//  notice, this list of conditions and the following disclaimer in the
//  documentation and/or other materials provided with the distribution.
//	Neither the name of the Drew Davidson nor the names of its contributors
//  may be used to endorse or promote products derived from this software
//  without specific prior written permission.
//
//	THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
//  "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
//  LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
//  FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
//  COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
//  INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
//  BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS
//  OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
//  AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
//  OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF
//  THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH
//  DAMAGE.
//--------------------------------------------------------------------------
package ariba.util.expr;

/**
 * @author Luke Blanshard (blanshlu@netscape.net)
 * @author Drew Davidson (drew@ognl.org)
 */
class ASTAnd extends ExpressionNode
{
    public ASTAnd(int id) {
        super(id);
    }

    public ASTAnd(ExprParser p, int id) {
        super(p, id);
    }

    public void jjtClose() {
        flattenTree();
    }

    protected Object getValueBody( ExprContext context, Object source ) throws ExprException
    {
        Object result = null;
        int last = children.length - 1;
        for ( int i=0; i <= last; ++i ) {
            result = children[i].getValue( context, source );
            if ( i != last && ! ExprOps.booleanValue(result) )
                break;
        }
        return Boolean.valueOf(ExprOps.booleanValue(result));
    }

    protected void setValueBody( ExprContext context, Object target, Object value ) throws ExprException
    {
        int last = children.length - 1;
        for ( int i=0; i < last; ++i ) {
            Object v = children[i].getValue( context, target );
            if ( ! ExprOps.booleanValue(v) )
                return;
        }
        children[last].setValue( context, target, value );
    }

    public String getExpressionOperator(int index)
    {
        return "&&";
    }

    public int getExpressionType ()
    {
        return LogicalExpression;
    }
}
