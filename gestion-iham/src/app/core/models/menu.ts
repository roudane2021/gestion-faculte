import { IMenu } from "./core";


export const  menuAdmin: IMenu[] = [

{
    text: "MENU.DEPARTEMENT.TITRE",
    icon: "people",
    routerLink: "./departement"
},
{
    text: "MENU.COURS.TITRE",
    icon: "inventory_2",
    children: [{
            text: "MENU.COURS.SUB.LIST",
            icon: "category",
            routerLink: "./cours"
        }
    ]
}
]

export const  menuEtudiant: IMenu[] = [

    {
        text: "Customer",
        icon: "people",
        routerLink: "/customer/manage"
    },
    {
        text: "Suit",
        icon: "inventory_2",
        children: [{
                text: "Category",
                icon: "category",
                routerLink: "/product/category"
            },
            {
                text: "Sub Category",
                icon: "layers",
                routerLink: "/product/sub-category"
            },
            {
                text: "Product",
                icon: "all_inbox",
                routerLink: "/product/manage"
            }
        ]
    }
    ]