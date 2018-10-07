<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="left-ads-display col-lg-9">
   <div class="row">
<c:forEach var="product" items="${products}">

      <div class="col-lg-4 col-md-6 col-sm-6 product-men women_two">
         <div class="product-toys-info">
            <div class="men-pro-item">
               <div class="men-thumb-item">
                  <img src="${product.image_url }" class="img-thumbnail img-fluid" alt="">
                  <div class="men-cart-pro">
                     <div class="inner-men-cart-pro">
                        <a href="single.html" class="link-product-add-cart">Quick View</a>
                     </div>
                  </div>
               </div>
               <div class="item-info-product">
                  <div class="info-product-price">
                     <div class="grid_meta">
                        <div class="product_price">
                           <h4>
                              <a href="single.html">${product.product_name }</a>
                           </h4>
                           <div class="grid-price mt-2">
                              <span class="money ">${product.price }</span>
                           </div>
                        </div>
                     </div>
                  </div>
                  <div class="clearfix"></div>
               </div>
            </div>
         </div>
      </div>
      </c:forEach>
   </div>
</div>
