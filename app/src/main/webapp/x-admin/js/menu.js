var menuLoad = {
    		init:function  () {
    			$.ajax({
    				type: "get",
    				url: "/menu/list.ajax",
    				async: true,
    				dataType:"json",
    				success: function(data){
    					if(data && data.code==0){
    						menuLoad.renderMenu(data.data);
    						menuLoad.clickEvent();
    					}
    				}
    			});
    		},
    		
    		renderMenu:function (menuArr){
    			var html='';
    			html += menuLoad.appendMenus(menuArr)
    			$(".layui-table").append(html)
    		},
    		appendMenus: function(nodes){
    			var html='';
    			for(var i in nodes){
    				if( nodes[i].parentId == 0){
    					html += '<tr>'
    				}else{
    					html += '<tr class="trc'+nodes[i].parentId+'" style="display:none">'
    				}
    				html += menuLoad.appendNodeMenu(nodes[i]);
    				if(nodes[i].childMenu.length > 0){
    					html += menuLoad.appendChildNode(nodes[i].childMenu);
    				}
    				html += '</tr>';
    			}
    			return html;
    		},
    		appendNodeMenu: function(node){
    			var html = '';
    			html += '<td onclick="menuLoad.showChild('+node.imenu+','+node.level+');"><span>'+node.menuName+'</span></td>' ;
    			html += '<td>'+node.menuUrl+'</td>';
    			html += '<td>'+node.order+'</td>';
    			html += '<td><a title="修改" lay-event="edit" href="javascript:edit('+node.imenu+');">修改</a>&nbsp;&nbsp;';
    			html += '<a title="删除" lay-event="del" href="javascript:del('+node.imenu+');">删除</a></td>';
    			
    			return html;
    		},
    		appendChildNode: function(nodes){
    			
    			var html = '<tr class="">';
    			html += menuLoad.appendMenus(nodes);
    			html += '</tr>';
    			return html;
    		},
    		showChild: function(id,level){
    			$('.trc'+id).toggle();
    			$('.trc'+id).each(function(){
    				var px = 30*(level+1)+'px';
    				$(this).find('span').attr("style","position:relative;margin-left:"+px);
    				
    			})
    		},
    		spanStyle:function(){
    			return "<span>";
    		}
    		   
        }