import * as base from "./baseService";
const model = "product";

export function getEmptyProduct(){
    return {
        productId: 0,
        productName: "",
        pictureUrl: ""
    };
}

export async function findAll() {
    return base.findAll(model);
}

export async function findById(productId) {
    return base.findById(model, productId);
}

export async function save(product) {
    return base.save(model, product, product.productId);
}

export async function deleteById(productId) {
    return base.deleteById(model, productId);
}